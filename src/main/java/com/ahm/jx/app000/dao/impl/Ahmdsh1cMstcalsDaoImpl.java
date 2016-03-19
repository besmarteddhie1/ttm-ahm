/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.Ahmdsh1cMstcalsDao;
import com.ahm.jx.app000.model.Ahmdsh1cMstcals;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsh1cMstcalsDao")
public class Ahmdsh1cMstcalsDaoImpl extends GenericHibernateDao<Ahmdsh1cMstcals, String>
        implements Ahmdsh1cMstcalsDao{
    
}
