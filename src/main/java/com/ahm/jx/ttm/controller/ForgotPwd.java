package com.ahm.jx.ttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPwd {
	
	@RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
	public String index() {
		return "forgotPwd";
	}

}
