package com.ahm.jx.ttm.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import com.ahm.jx.ttm.entities.UamMenu;
import com.ahm.jx.ttm.entities.UamUser;

@Repository
@Scope("session")
@RequestMapping(value = "/api/udm")
public class UserDataModule implements Serializable {

	private static final long serialVersionUID = 4520967229110760653L;
	
	@Autowired
	UamUserDao userDao;	
	
	String currentUser;
	
	@Transactional
	public boolean checkMe() {
		if (currentUser == null) {
			Authentication principal = SecurityContextHolder.getContext().getAuthentication();
			if (principal == null) return false;
			currentUser = principal.getName();
		}
		return true;
	}
	
    @RequestMapping(value = "whoami", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Transactional
    public String currentUser() {
    	if (!checkMe()) return "";
        return this.currentUser;
    }
    
    @RequestMapping(value = "menus", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @Transactional
    public List<UamMenu> activeMenu() {
    	if (!checkMe()) return null;
    	UamUser usr = userDao.findOneByUserName(this.currentUser);
    	System.out.println("Check 1 " +  this.currentUser + " ");
    	if (usr == null) return new ArrayList<UamMenu>(); 
    	System.out.println("Check 1 " +  this.currentUser + " " + usr.getUserRoles().size());
    	System.out.println("Check 2 " +  this.currentUser + " " + usr.getRoles().size());
    	System.out.println("Check 3 " +  this.currentUser + " " + usr.getMapMenu().size());    	
        return usr.getMenus();
    }    
		
}
