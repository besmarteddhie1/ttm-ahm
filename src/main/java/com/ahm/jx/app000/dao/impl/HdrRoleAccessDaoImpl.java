/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.HdrRoleAccessDao;
import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad
 */
@Repository("hdrRoleAccessDao")
public class HdrRoleAccessDaoImpl extends GenericHibernateDao<AhmdsuamHdrrlaccess, String> 
    implements HdrRoleAccessDao{
    
}
