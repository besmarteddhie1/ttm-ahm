/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app011.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.uam.app011.vo.Uam011VoAhmjxuamMstusers;

/**
 *
 * @author ferdy
 */
public interface Uam011Service {
	
    public DtoRespond forgotUsername(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers, String appId);

    public DtoRespond forgotPassword(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers, String appId);

}
