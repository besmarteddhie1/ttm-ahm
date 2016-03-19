/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamTxnbookmark;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsuamTxnbookmarkDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("dashboardAhmdsuamTxnbookmarkDao")
public class DashboardAhmdsuamTxnbookmarkDaoImpl extends GenericHibernateDao<AhmdsuamTxnbookmark, String>
    implements DashboardAhmdsuamTxnbookmarkDao{

    public List<VoAhmdsuamMstmenus> getMenusBookmark(String username) {
        List<VoAhmdsuamMstmenus> result = null;
        String hql = "SELECT  distinct(menu.vapplicationId) ,  menu.vtitle , menu.vurl, menu.vicon "
                + "FROM AhmdsuamTxnbookmark bkmrk ,AhmdsuamMstmenus menu , AhmdsuamMstusers user "
                + "WHERE bkmrk.vidAhmdsuamMstmenus IN ( SELECT menu.vid "
                + "FROM AhmdsuamMstusers user , AhmdsuamMstusrrols usrrls , "
                + "AhmdsuamMstroles roles , AhmdsuamHdrrlaccess rlacs , AhmdsuamMstmenus menu "
                + "WHERE user.vusername = :user "
                + "AND user.vid = usrrls.vidAhmdsuamMstusers "
                + "AND usrrls.vidAhmdsuamMstroles = roles.vid "
                + "AND rlacs.vidAhmdsuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmdsuamMstmenus) "
                + "AND menu.vid = bkmrk.vidAhmdsuamMstmenus "
                + "AND bkmrk.vidAhmdsuamMstusers = user.vid "
                + "AND user.vusername = :user ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString("user", username);
        List<Object[]> temp = query.list();
        if(temp!=null){
            result = new ArrayList<VoAhmdsuamMstmenus>();
            for(Object[] object : temp){
                VoAhmdsuamMstmenus voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();                
                voAhmdsuamMstmenus.setVapplicationId(object[0]+"");
                voAhmdsuamMstmenus.setVtitle(object[1]+"");
                voAhmdsuamMstmenus.setVurl(object[2]+"");
                voAhmdsuamMstmenus.setVicon(object[3]+"");
                result.add(voAhmdsuamMstmenus);
            }
        }
        return result;
    }
    
    public List<VoAhmdsuamMstmenus> getMenusBookmarkDefault(String username){
        List<VoAhmdsuamMstmenus> result = null;
        String hql = "SELECT menu.vapplicationId , menu.vtitle , menu.vurl, menu.vicon "
                + "FROM AhmdsbscDtlsetting dtlset , AhmdsuamMstmenus menu "
                + "WHERE dtlset.vidAhmdsbscHdrsetting = 'MST_BOOKMARK' "
                + "AND menu.vapplicationId IN ( "
                + "SELECT menu.vapplicationId "
                + "FROM AhmdsuamMstusers user , AhmdsuamMstusrrols usrrls , "
                + "AhmdsuamMstroles roles , AhmdsuamHdrrlaccess rlacs , AhmdsuamMstmenus menu "
                + "WHERE user.vusername = :user "
                + "AND user.vid = usrrls.vidAhmdsuamMstusers "
                + "AND usrrls.vidAhmdsuamMstroles = roles.vid "
                + "AND rlacs.vidAhmdsuamMstroles = roles.vid "
                + "AND menu.vid = rlacs.vidAhmdsuamMstmenus ) "
                + "AND menu.vapplicationId = dtlset.vitemcode ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString("user", username);
        List<Object[]> temp = query.list();
        if(temp!=null){
            result = new ArrayList<VoAhmdsuamMstmenus>();
            for(Object[] object : temp){
                VoAhmdsuamMstmenus voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();                
                voAhmdsuamMstmenus.setVapplicationId(object[0]+"");
                voAhmdsuamMstmenus.setVtitle(object[1]+"");
                voAhmdsuamMstmenus.setVurl(object[2]+"");
                voAhmdsuamMstmenus.setVicon(object[3]+"");
                result.add(voAhmdsuamMstmenus);
            }
        }
        return result;
    }
    
    public String getBookMarkVid(String username,String applicationId){
        String result = null;
        String hql = "SELECT bkmrk.vid "
                + "FROM AhmdsuamTxnbookmark bkmrk , AhmdsuamMstmenus menu , "
                + "AhmdsuamMstusers users "
                + "WHERE bkmrk.vidAhmdsuamMstmenus = menu.vid "
                + "AND menu.vapplicationId = :applicationId "
                + "AND users.vid = bkmrk.vidAhmdsuamMstusers "
                + "AND users.vusername = :username ";
        Query query  = getCurrentSession().createQuery(hql);
        query.setString("applicationId", applicationId);
        query.setString("username", username);
        List<String> temp = query.list();
        if(!temp.isEmpty()){
            return temp.get(0);
        }
        return result;
    }
    
}
