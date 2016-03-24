package com.ahm.jx.ttm.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.entities.UamMenu;
import com.ahm.jx.ttm.entities.UamUser;

@Component
@Scope("session")
@RequestMapping(value = "/api/udm")
public class UserDataModule implements Serializable {

	private static final long serialVersionUID = 4520967229110760653L;
	
	@Autowired
	UamUserDao userDao;	
	
	String currentUser;
	
	UamUser activeUser = null;	
	
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
    	activeUser = userDao.findOneByUserName(this.currentUser);
    	if (activeUser == null) return new ArrayList<UamMenu>(); 
        return activeUser.getMenus();
    }    
		
}
