package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.model.AhmjxUamUser;

@Controller
public class UamuserController {
   private UamUserDao uamuserRepository;
   
   @Autowired
   public UamuserController(UamUserDao uamuser) {
       this.uamuserRepository = uamuser;
   }
   
   @RequestMapping(value = "uamuser/test", method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public String test() {
       return "test ok";
   }
  

   @RequestMapping(value = "uamuser/", method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public List<AhmjxUamUser> userGetAll() {
	   
   System.out.println("aaa"+ uamuserRepository.findAll());
       return uamuserRepository.findAll();
   }
   
   @RequestMapping(value = "uamuser/{name}", method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public AhmjxUamUser user(@PathVariable("name") String userName) {
       return uamuserRepository.findOneByUserName(userName);
   }
}
