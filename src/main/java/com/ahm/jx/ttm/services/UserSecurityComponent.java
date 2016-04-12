package com.ahm.jx.ttm.services;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.Md5Crypt;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.entities.UamUser;

@Component
public class UserSecurityComponent implements Serializable {

	private static final long serialVersionUID = -2749998599804213375L;

	@Autowired
	UamUserDao userDao;	
	
	private String currentUser;
	
	Date lastCheckLogin;
		
	@PostConstruct
	private void StartUp() {
		lastCheckLogin = new Date();
	}
	
    
    public boolean TimeOut() {
    	Period nl = new Period(new DateTime(), new DateTime(lastCheckLogin));
    	return nl.getMinutes() >= 20;
    }
    
    public boolean ValidLogin(String password) {
    	UamUser usr = userDao.findOneByUserName(getCurrentUser());
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
