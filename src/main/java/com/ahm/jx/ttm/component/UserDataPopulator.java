package com.ahm.jx.ttm.component;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ahm.jx.ttm.model.AhmjxUamUser;
import com.ahm.jx.ttm.repository.AhmjxUamUserRepository;
import com.ahm.jx.ttm.utils.log.Log;

@Component
public class UserDataPopulator implements ApplicationListener<ContextRefreshedEvent> {
	
	@Log
	private Logger log;
	
	@Inject
	private AhmjxUamUserRepository repo;
	
	private void BuildOneUser(String userName, String password) {
		if (repo.findOneByUserName(userName) == null) {
			AhmjxUamUser us = new AhmjxUamUser();
			us.setUserName(userName);
			us.setPassword(password);
			us.setStatus(true);
			repo.save(us);
			log.info("User: " + userName + " created..");
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {		
		log.info("ApplicationListener Invoked At Spring Container Startup");
		
		BuildOneUser("admin", "9ce21d8f3992d89a325aa9dcf520a591");
		BuildOneUser("root", "9ce21d8f3992d89a325aa9dcf520a591");
	}


}
