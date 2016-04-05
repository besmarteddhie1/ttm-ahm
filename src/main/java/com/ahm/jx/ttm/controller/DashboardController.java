package com.ahm.jx.ttm.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Principal principal) {
		return principal != null ? "dashboard" : "login";
	}

}
