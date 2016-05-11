package com.ahm.jx.ttm.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.Md5Crypt;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.model.AhmjxUamMenu;
import com.ahm.jx.ttm.model.AhmjxUamUser;

@Repository
@Scope("session")
@RequestMapping(value = "/api/udm")
public class UserDataModule implements Serializable {

	private static final long serialVersionUID = 4520967229110760653L;
	
	@Autowired
	UamUserDao userDao;	
	
	private String currentUser;
	
	Date lastCheckLogin;
	
	
	@PostConstruct
	private void StartUp() {
		lastCheckLogin = new Date();
	}
	
    @RequestMapping(value = "whoami", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Transactional
    public String currentUser() {
        return getCurrentUser();
    }
    
    @RequestMapping(value = "menus", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Transactional
    public List<AhmjxUamMenu> activeMenu() {
    	AhmjxUamUser usr = userDao.findOneByUserName(getCurrentUser());
    	System.out.println("AhmjxUamUser usr"+ usr);
    	if (usr == null) return new ArrayList<AhmjxUamMenu>(); 
        return usr.getMenus();
    }
    
    public boolean TimeOut() {
    	Period nl = new Period(new DateTime(), new DateTime(lastCheckLogin));
    	return nl.getMinutes() >= 20;
    }
    
    public boolean ValidLogin(String password) {
    	AhmjxUamUser usr = userDao.findOneByUserName(getCurrentUser());
    	Boolean isTrue = usr.getPassword().equals(Md5Crypt.apr1Crypt(password, null));
    	if (isTrue) lastCheckLogin = new Date();
    	return isTrue;
    }
    
	public String getCurrentUser() {
		Authentication principal = SecurityContextHolder.getContext().getAuthentication();
		if (principal != null) currentUser = principal.getName();		
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}    
		
}
