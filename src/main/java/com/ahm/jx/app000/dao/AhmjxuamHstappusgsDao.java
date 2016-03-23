/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.AhmjxuamHstappusgs;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author sigit
 */
public interface AhmjxuamHstappusgsDao extends GenericDao<AhmjxuamHstappusgs, String> {

    public List<AhmjxuamHstappusgs> getAllHstappusgs();

}
