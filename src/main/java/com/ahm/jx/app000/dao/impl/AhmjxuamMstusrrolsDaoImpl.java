/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstusrrolsDao;
import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad
 */
@Repository("ahmjxuamMstusrrolsDao")
public class AhmjxuamMstusrrolsDaoImpl extends GenericHibernateDao<AhmjxuamMstusrrols, String>
        implements AhmjxuamMstusrrolsDao {

}
