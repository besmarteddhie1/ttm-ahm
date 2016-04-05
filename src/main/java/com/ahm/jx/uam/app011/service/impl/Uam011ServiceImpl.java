/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app011.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahm.jx.app000.config.GeneratePass;
import com.ahm.jx.app000.config.MailMail;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.uam.app001.service.Uam001Service;
import com.ahm.jx.uam.app009.dao.Uam009AhmjxuamHstappusgsDao;
import com.ahm.jx.uam.app011.dao.Uam011AhmjxuamMstusersDao;
import com.ahm.jx.uam.app011.service.Uam011Service;
import com.ahm.jx.uam.app011.vo.Uam011VoAhmjxuamMstusers;
import com.twmacinta.util.MD5;

/**
 *
 * @author ferdy
 */
@Service("uam011Service")
@Transactional(readOnly = true)
public class Uam011ServiceImpl implements Uam011Service{

	 @Autowired
	 @Qualifier("uam011AhmjxuamMstusersDao")
	 private Uam011AhmjxuamMstusersDao uam011AhmjxuamMstusersDao;
	
    @Transactional(readOnly = false)
    public DtoRespond forgotUsername(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers,  String appId) {
        DtoRespond dtoRespond = new DtoRespond();
//        if (dtoRespond.getStat().equals(CommonConstant._200)) {
        	System.out.println("tes=>"+uam011VoAhmjxuamMstusers.getVfullname());
//            AhmjxuamMstusers ahmjxuamMstusers = new AhmjxuamMstusers();
//            ahmjxuamMstusers.setVid(uam001VoAhmjxuamMstuser.getVid());
//            ahmjxuamMstusers.setVusername(uam001VoAhmjxuamMstuser.getVusername());
//            ahmjxuamMstusers.setVidAhmjxuamMstpartner(uam001VoAhmjxuamMstuser.getVidDlr());
//            String passMD5 = new MD5(Uam001Util.INIT_PASSWORD).asHex();
//            ahmjxuamMstusers.setVpassword(passMD5);
//            ahmjxuamMstusers.setVstat("T");
            //System.out.println("Nilai : " + uam002VoAhmdsuamMstuser.getVusername() + "--" + uam002VoAhmdsuamMstuser.getVpassword() + "--" + uam002VoAhmdsuamMstuser.getVstat());
//            uam001AhmjxuamMstuserDao.save(ahmjxuamMstusers, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Reset Password");
        return dtoRespond;
    }
    
    @Transactional(readOnly = false)
    public DtoRespond forgotPassword(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers,  String appId) {
        DtoRespond dtoRespond = new DtoRespond();											
        	
//        List<Uam011VoAhmjxuamMstusers> list = uam011AhmjxuamMstusersDao.getByUsername(uam011VoAhmjxuamMstusers.getVusername());
        
        @SuppressWarnings("resource")
    		ApplicationContext context = 
    	            new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	    	 
    	    	MailMail mm = (MailMail) context.getBean("MailMail");
    			String gp = GeneratePass.generateRandomPassword();

    	    	String name = uam011VoAhmjxuamMstusers.getVusername();
    	    	String content = "Your new password is : "+gp;
//    	    	String email = user.getVuseremail();
    	    	String email = "ferdy.indrawan@gmail.com";
    	    	String subject = "Reset Password";					

//    	    	String content = ((p == 1) ? content1 : content2);

    	    	mm.sendMail(name, content,email,subject);	
        	
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Reset Password");

        return dtoRespond;
    }

}
