/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdspimMstfincoyDao;
import com.ahm.jx.app000.model.AhmdspimMstfincoy;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laurentinus
 */
@Repository("ahmdspimMstfincoyDao")
public class AhmdspimMstfincoyDaoImpl extends GenericHibernateDao<AhmdspimMstfincoy, String>
        implements AhmdspimMstfincoyDao{
    
}
