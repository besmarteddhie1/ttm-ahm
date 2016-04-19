package com.ahm.jx.ttm.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
	
	@RequestMapping(value = {"/login", "/login.htm"}, method = RequestMethod.GET)
	public String login(Principal principal) {
		return principal != null ? "dashboard" : "login";
	}

}
