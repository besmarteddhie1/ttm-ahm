/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.Ahmdsh1cMstpartnerDao;
import com.ahm.jx.app000.model.Ahmdsh1cMstpartner;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laurentinus
 */
@Repository("ahmdsh1cMstpartnerDao")
public class Ahmdsh1cMstpartnerDaoImpl extends GenericHibernateDao<Ahmdsh1cMstpartner, String> 
    implements Ahmdsh1cMstpartnerDao{
    
}
