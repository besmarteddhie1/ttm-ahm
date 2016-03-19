/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;
import com.ahm.jx.app000.dao.AhmdsmunMstprospekDao;
import com.ahm.jx.app000.model.Ahmdsh1cMstprospek;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laurentinus
 */
@Repository("ahmdsmunMstprospekDao")
public class AhmdsmunMstprospekDaoImpl extends GenericHibernateDao<Ahmdsh1cMstprospek, String>
        implements AhmdsmunMstprospekDao{
    
}
