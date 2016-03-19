/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.app000.vo.VoAhmdsbscMstdlrcode;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstroles;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsuamMstusersDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("dashboardAhmdsuamMstusersDao")
public class DashboardAhmdsuamMstusersDaoImpl extends GenericHibernateDao<AhmdsuamMstusers, String>
    implements DashboardAhmdsuamMstusersDao{

    public List<VoAhmdsuamMstmenus> getMenuByUser(String userName) {
        List<VoAhmdsuamMstmenus> list = new ArrayList<VoAhmdsuamMstmenus>();
        String hql = "SELECT DISTINCT(menu.vid) , menu.vapplicationId , menu.vtitle , "
                + "menu.vurl , menu.vparent , menu.vicon "
                + "FROM AhmdsuamMstusers user , AhmdsuamMstusrrols usrrls ,"
                + "AhmdsuamMstroles roles , AhmdsuamHdrrlaccess rlacs , AhmdsuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND user.vid = usrrls.vidAhmdsuamMstusers "
                + "AND usrrls.vidAhmdsuamMstroles = roles.vid "
                + "AND rlacs.vidAhmdsuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmdsuamMstmenus ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        List<Object[]> temp = query.list();
        if(temp!=null){
            for(Object[] object : temp){
                VoAhmdsuamMstmenus voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();
                voAhmdsuamMstmenus.setVid(object[0]+"");
                voAhmdsuamMstmenus.setVapplicationId(object[1]+"");
                voAhmdsuamMstmenus.setVtitle(object[2]+"");
                voAhmdsuamMstmenus.setVurl(object[3]+"");
                voAhmdsuamMstmenus.setVparent(object[4]+"");
                voAhmdsuamMstmenus.setVicon(object[5]+"");
                list.add(voAhmdsuamMstmenus);
            }
        }        
        return list;
    }
    
    public VoAhmdsuamMstmenus getMenuByUserByAppid(String userName,String appId) {
        VoAhmdsuamMstmenus voAhmdsuamMstmenus = null;
        String hql = "SELECT DISTINCT(menu.vid) , menu.vapplicationId , menu.vtitle , "
                + "menu.vurl , menu.vparent "
                + "FROM AhmdsuamMstusers user , AhmdsuamMstusrrols usrrls ,"
                + "AhmdsuamMstroles roles , AhmdsuamHdrrlaccess rlacs , AhmdsuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND menu.vapplicationId = ? "
                + "AND user.vid = usrrls.vidAhmdsuamMstusers "
                + "AND usrrls.vidAhmdsuamMstroles = roles.vid "
                + "AND rlacs.vidAhmdsuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmdsuamMstmenus ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        query.setString(1, appId);
        Object[] temp = (Object[]) query.uniqueResult();
        if(temp!=null){            
            voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();
            voAhmdsuamMstmenus.setVid(temp[0]+"");
            voAhmdsuamMstmenus.setVapplicationId(temp[1]+"");
            voAhmdsuamMstmenus.setVtitle(temp[2]+"");
            voAhmdsuamMstmenus.setVurl(temp[3]+"");
            voAhmdsuamMstmenus.setVparent(temp[4]+"");              
        }
        return voAhmdsuamMstmenus;
    }
    

    public AhmdsuamMstusers getAhmdsuamMstuserByUsername(String userName) {
        AhmdsuamMstusers ahmdsuamMstusers = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class,"ahmdsuamMstusers");
        criteria.add(Restrictions.eq("vusername", userName));
        ahmdsuamMstusers = (AhmdsuamMstusers)criteria.uniqueResult();
        return ahmdsuamMstusers;
    }
    
    public VoAhmdsbscMstdlrcode getDealerInfoByUsername(String userName){
        VoAhmdsbscMstdlrcode voAhmdsbscMstdlrcode = null;
        String hql = "SELECT dlr.vid , "
                + "dlr.vdealercode , dlr.vaddress , "
                + "dlr.vname , dlr.vowner , dlr.vphonemun , "
                + "dlr.vcity , dlr.vmdcode , dlr.dbegineff , "
                + "dlr.dendeff , dlr.nlevel , dlr.vmddlrcode , "
                + "dlr.npit "
                + "FROM AhmdsuamMstusers user , AhmdsbscMstdlrcode dlr "
                + "WHERE user.vusername = ? "
                + "AND dlr.vid = user.vidAhmdsbscMstdlrcode ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString(0, userName);
//        List<Object[]> temp = query.list();
        Object[] temp = (Object[]) query.uniqueResult();
        if(temp!=null){
            voAhmdsbscMstdlrcode = new VoAhmdsbscMstdlrcode();
            voAhmdsbscMstdlrcode.setVid(temp[0]+"");
            voAhmdsbscMstdlrcode.setVdealercode(temp[1]+"");
            voAhmdsbscMstdlrcode.setVaddress(temp[2]+"");
            voAhmdsbscMstdlrcode.setVname(temp[3]+"");
            voAhmdsbscMstdlrcode.setVowner(temp[4]+"");
            voAhmdsbscMstdlrcode.setVphonemun(temp[5]+"");
            voAhmdsbscMstdlrcode.setVcity(temp[6]+"");
            voAhmdsbscMstdlrcode.setVmdcode(temp[7]+"");
            
        }
        return voAhmdsbscMstdlrcode;
    }
    
    public List<VoAhmdsuamMstroles> getRoleByAppAndUser(String username,String vid){
        List<VoAhmdsuamMstroles> list = null;
        String hql = "SELECT role.vid , role.vrolesId "
                + "FROM AhmdsuamMstusers user, AhmdsuamMstusrrols usrrole , "
                + "AhmdsuamMstroles role , AhmdsuamHdrrlaccess rlacs , "
                + "AhmdsuamMstmenus menu "
                + "WHERE user.vusername = ? "
                + "AND menu.vid = ? "
                + "AND user.vid = usrrole.vidAhmdsuamMstusers "
                + "AND role.vid = usrrole.vidAhmdsuamMstroles "
                + "AND role.vid = rlacs.vidAhmdsuamMstroles "
                + "AND menu.vid = rlacs.vidAhmdsuamMstmenus";
                
        Query query  = getCurrentSession().createQuery(hql);
        query.setString(0, username);
        query.setString(1, vid);
        List<Object[]> temp = query.list();
        if(temp!=null){
            list = new ArrayList();
            for(int i=0;i<temp.size();i++){
                VoAhmdsuamMstroles voAhmdsuamMstroles = new VoAhmdsuamMstroles();
                voAhmdsuamMstroles.setVid(temp.get(i)[0]+"");                        
                voAhmdsuamMstroles.setVrolesId(temp.get(i)[1]+"");            
                list.add(voAhmdsuamMstroles);
            }
        }
        return list;
    }
}
