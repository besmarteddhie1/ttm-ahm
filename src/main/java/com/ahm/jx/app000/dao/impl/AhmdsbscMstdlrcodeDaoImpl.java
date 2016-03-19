/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsbscMstdlrcodeDao;
import com.ahm.jx.app000.model.AhmdsbscMstdlrcode;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsbscMstdlrcodeDao")
public class AhmdsbscMstdlrcodeDaoImpl extends GenericHibernateDao<AhmdsbscMstdlrcode, String>
        implements AhmdsbscMstdlrcodeDao{
    
}
