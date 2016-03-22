/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.vo.VoAhmjxuamMstpartner;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstusersDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("dashboardAhmjxuamMstusersDao")
public class DashboardAhmjxuamMstusersDaoImpl extends GenericHibernateDao<AhmjxuamMstusers, String>
        implements DashboardAhmjxuamMstusersDao {

    public List<VoAhmjxuamMstmenus> getMenuByUser(String userName) {
        List<VoAhmjxuamMstmenus> list = new ArrayList<VoAhmjxuamMstmenus>();
        String hql = "SELECT DISTINCT(menu.vid) , menu.vapplicationId , menu.vtitle , "
                + "menu.vurl , menu.vparent , menu.vicon "
                + "FROM AhmjxuamMstusers user , AhmjxuamMstusrrols usrrls ,"
                + "AhmjxuamMstroles roles , AhmjxuamHdrrlaccess rlacs , AhmjxuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND user.vid = usrrls.vidAhmjxuamMstusers "
                + "AND usrrls.vidAhmjxuamMstroles = roles.vid "
                + "AND rlacs.vidAhmjxuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmjxuamMstmenus ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        List<Object[]> temp = query.list();
        if (temp != null) {
            for (Object[] object : temp) {
                VoAhmjxuamMstmenus voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
                voAhmjxuamMstmenus.setVid(object[0] + "");
                voAhmjxuamMstmenus.setVapplicationId(object[1] + "");
                voAhmjxuamMstmenus.setVtitle(object[2] + "");
                voAhmjxuamMstmenus.setVurl(object[3] + "");
                voAhmjxuamMstmenus.setVparent(object[4] + "");
                voAhmjxuamMstmenus.setVicon(object[5] + "");
                list.add(voAhmjxuamMstmenus);
            }
        }
        return list;
    }

    public VoAhmjxuamMstmenus getMenuByUserByAppid(String userName, String appId) {
        VoAhmjxuamMstmenus voAhmjxuamMstmenus = null;
        String hql = "SELECT DISTINCT(menu.vid) , menu.vapplicationId , menu.vtitle , "
                + "menu.vurl , menu.vparent "
                + "FROM AhmjxuamMstusers user , AhmjxuamMstusrrols usrrls ,"
                + "AhmjxuamMstroles roles , AhmjxuamHdrrlaccess rlacs , AhmjxuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND menu.vapplicationId = ? "
                + "AND user.vid = usrrls.vidAhmjxuamMstusers "
                + "AND usrrls.vidAhmjxuamMstroles = roles.vid "
                + "AND rlacs.vidAhmjxuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmjxuamMstmenus ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        query.setString(1, appId);
        Object[] temp = (Object[]) query.uniqueResult();
        if (temp != null) {
            voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
            voAhmjxuamMstmenus.setVid(temp[0] + "");
            voAhmjxuamMstmenus.setVapplicationId(temp[1] + "");
            voAhmjxuamMstmenus.setVtitle(temp[2] + "");
            voAhmjxuamMstmenus.setVurl(temp[3] + "");
            voAhmjxuamMstmenus.setVparent(temp[4] + "");
        }
        return voAhmjxuamMstmenus;
    }

    public AhmjxuamMstusers getAhmjxuamMstuserByUsername(String userName) {
        AhmjxuamMstusers ahmjxuamMstusers = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class, "ahmjxuamMstusers");
        criteria.add(Restrictions.eq("vusername", userName));
        ahmjxuamMstusers = (AhmjxuamMstusers) criteria.uniqueResult();
        return ahmjxuamMstusers;
    }

    public VoAhmjxuamMstpartner getDealerInfoByUsername(String userName) {
        VoAhmjxuamMstpartner voAhmjxuamMstpartner = null;
        String hql = "SELECT dlr.vid , "
                + "dlr.vdealercode , dlr.vaddress , "
                + "dlr.vname , dlr.vowner , dlr.vphonenum, "
                + "dlr.vcity , dlr.vmdcode , dlr.dbegineff , "
                + "dlr.dendeff , dlr.nlevel , dlr.vmddlrcode , "
                + "dlr.npit "
                + "FROM AhmjxuamMstusers user , AhmjxuamMstpartner dlr "
                + "WHERE user.vusername = ? "
                + "AND dlr.vid = user.vidAhmjxuamMstpartner ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
//        List<Object[]> temp = query.list();
        Object[] temp = (Object[]) query.uniqueResult();
        if (temp != null) {
            voAhmjxuamMstpartner = new VoAhmjxuamMstpartner();
            voAhmjxuamMstpartner.setVid(temp[0] + "");
            voAhmjxuamMstpartner.setVdealercode(temp[1] + "");
            voAhmjxuamMstpartner.setVaddress(temp[2] + "");
            voAhmjxuamMstpartner.setVname(temp[3] + "");
            voAhmjxuamMstpartner.setVowner(temp[4] + "");
            voAhmjxuamMstpartner.setVphonenum(temp[5] + "");
            voAhmjxuamMstpartner.setVcity(temp[6] + "");
            voAhmjxuamMstpartner.setVmdcode(temp[7] + "");

        }
        return voAhmjxuamMstpartner;
    }

    public List<VoAhmjxuamMstroles> getRoleByAppAndUser(String username, String vid) {
        List<VoAhmjxuamMstroles> list = null;
        String hql = "SELECT role.vid , role.vrolesId "
                + "FROM AhmjxuamMstusers user, AhmjxuamMstusrrols usrrole , "
                + "AhmjxuamMstroles role , AhmjxuamHdrrlaccess rlacs , "
                + "AhmjxuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND menu.vid = ? "
                + "AND user.vid = usrrole.vidAhmjxuamMstusers "
                + "AND role.vid = usrrole.vidAhmjxuamMstroles "
                + "AND role.vid = rlacs.vidAhmjxuamMstroles "
                + "AND menu.vid = rlacs.vidAhmjxuamMstmenus";

        Query query = getCurrentSession().createQuery(hql);
        query.setString(0, username);
        query.setString(1, vid);
        List<Object[]> temp = query.list();
        if (temp != null) {
            list = new ArrayList();
            for (int i = 0; i < temp.size(); i++) {
                VoAhmjxuamMstroles voAhmjxuamMstroles = new VoAhmjxuamMstroles();
                voAhmjxuamMstroles.setVid(temp.get(i)[0] + "");
                voAhmjxuamMstroles.setVrolesId(temp.get(i)[1] + "");
                list.add(voAhmjxuamMstroles);
            }
        }
        return list;
    }
}
