package com.ahm.jx.ttm.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "dashboard" : "login";
	}
	
	@RequestMapping(value = "login")
	public String login() {
        return "login";
    }	
	
	@RequestMapping(value = "dashboard")
	public String dashboard() {
        return "dashboard";
    }	
}
