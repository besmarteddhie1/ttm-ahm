/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamTxnbookmark;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamTxnbookmarkDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("dashboardAhmjxuamTxnbookmarkDao")
public class DashboardAhmjxuamTxnbookmarkDaoImpl extends GenericHibernateDao<AhmjxuamTxnbookmark, String>
        implements DashboardAhmjxuamTxnbookmarkDao {

    public List<VoAhmjxuamMstmenus> getMenusBookmark(String username) {
        List<VoAhmjxuamMstmenus> result = null;
        String hql = "SELECT  distinct(menu.vapplicationId) ,  menu.vtitle , menu.vurl, menu.vicon "
                + "FROM AhmjxuamTxnbookmark bkmrk ,AhmjxuamMstmenus menu , AhmjxuamMstusers user "
                + "WHERE bkmrk.vidAhmjxuamMstmenus IN ( SELECT menu.vid "
                + "FROM AhmjxuamMstusers user , AhmjxuamMstusrrols usrrls , "
                + "AhmjxuamMstroles roles , AhmjxuamHdrrlaccess rlacs , AhmjxuamMstmenus menu "
                + "WHERE user.vusername = :user "
                + "AND user.vid = usrrls.vidAhmjxuamMstusers "
                + "AND usrrls.vidAhmjxuamMstroles = roles.vid "
                + "AND rlacs.vidAhmjxuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmjxuamMstmenus) "
                + "AND menu.vid = bkmrk.vidAhmjxuamMstmenus "
                + "AND bkmrk.vidAhmjxuamMstusers = user.vid "
                + "AND user.vusername = :user ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString("user", username);
        List<Object[]> temp = query.list();
        if (temp != null) {
            result = new ArrayList<VoAhmjxuamMstmenus>();
            for (Object[] object : temp) {
                VoAhmjxuamMstmenus voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
                voAhmjxuamMstmenus.setVapplicationId(object[0] + "");
                voAhmjxuamMstmenus.setVtitle(object[1] + "");
                voAhmjxuamMstmenus.setVurl(object[2] + "");
                voAhmjxuamMstmenus.setVicon(object[3] + "");
                result.add(voAhmjxuamMstmenus);
            }
        }
        return result;
    }

    public List<VoAhmjxuamMstmenus> getMenusBookmarkDefault(String username) {
        List<VoAhmjxuamMstmenus> result = null;
        String hql = "SELECT menu.vapplicationId , menu.vtitle , menu.vurl, menu.vicon "
                + "FROM AhmdsbscDtlsetting dtlset , AhmjxuamMstmenus menu "
                + "WHERE dtlset.vidAhmdsbscHdrsetting = 'MST_BOOKMARK' "
                + "AND menu.vapplicationId IN ( "
                + "SELECT menu.vapplicationId "
                + "FROM AhmjxuamMstusers user , AhmjxuamMstusrrols usrrls , "
                + "AhmjxuamMstroles roles , AhmjxuamHdrrlaccess rlacs , AhmjxuamMstmenus menu "
                + "WHERE user.vusername = :user "
                + "AND user.vid = usrrls.vidAhmjxuamMstusers "
                + "AND usrrls.vidAhmjxuamMstroles = roles.vid "
                + "AND rlacs.vidAhmjxuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmjxuamMstmenus ) "
                + "AND menu.vapplicationId = dtlset.vitemcode ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString("user", username);
        List<Object[]> temp = query.list();
        if (temp != null) {
            result = new ArrayList<VoAhmjxuamMstmenus>();
            for (Object[] object : temp) {
                VoAhmjxuamMstmenus voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
                voAhmjxuamMstmenus.setVapplicationId(object[0] + "");
                voAhmjxuamMstmenus.setVtitle(object[1] + "");
                voAhmjxuamMstmenus.setVurl(object[2] + "");
                voAhmjxuamMstmenus.setVicon(object[3] + "");
                result.add(voAhmjxuamMstmenus);
            }
        }
        return result;
    }

    public String getBookMarkVid(String username, String applicationId) {
        String result = null;
        String hql = "SELECT bkmrk.vid "
                + "FROM AhmjxuamTxnbookmark bkmrk , AhmjxuamMstmenus menu , "
                + "AhmjxuamMstusers users "
                + "WHERE bkmrk.vidAhmjxuamMstmenus = menu.vid "
                + "AND menu.vapplicationId = :applicationId "
                + "AND users.vid = bkmrk.vidAhmjxuamMstusers "
                + "AND users.vusername = :username ";
        Query query = getCurrentSession().createQuery(hql);
        query.setString("applicationId", applicationId);
        query.setString("username", username);
        List<String> temp = query.list();
        if (!temp.isEmpty()) {
            return temp.get(0);
        }
        return result;
    }

}
