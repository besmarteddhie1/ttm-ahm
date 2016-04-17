package com.ahm.jx.ttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotUserName {
	
	@RequestMapping(value = "/forgotUsername", method = RequestMethod.GET)
	public String index() {
		return "forgotUsername";
	}

}
