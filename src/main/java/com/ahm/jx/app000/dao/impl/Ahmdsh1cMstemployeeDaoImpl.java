/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.Ahmdsh1cMstemployeeDao;
import com.ahm.jx.app000.model.Ahmdsh1cMstemployee;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsh1cMstemployeeDao")
public class Ahmdsh1cMstemployeeDaoImpl extends GenericHibernateDao<Ahmdsh1cMstemployee, String>
        implements Ahmdsh1cMstemployeeDao{
    
}
