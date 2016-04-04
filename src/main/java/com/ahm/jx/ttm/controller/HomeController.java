package com.ahm.jx.ttm.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "dashboard" : "login";
	}

}
