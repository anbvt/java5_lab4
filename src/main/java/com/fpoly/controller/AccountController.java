package com.fpoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpoly.service.CookieService;
import com.fpoly.service.ParamService;
import com.fpoly.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;

	@GetMapping("/account/login")
	public String login1() {
		return "/account/login";
	}

	@PostMapping("/account/login")
	public String login2() {
		String un = paramService.getString("username", "");
		String pw = paramService.getString("password", "");
		boolean rm = paramService.getBoolean("remember", false);
//		System.out.println(un + ";" + pw + ";" + rm);
		if(un.equals("poly") && pw.equals("123")) {
			sessionService.set("username", un);
			if(rm) {
				cookieService.add("user", un, 24);
			}else {
				cookieService.remove("user");
			}
			return "redirect:/account/welcome";
		}
		return "/account/login";
	}
	
	@ResponseBody
	@GetMapping("/account/welcome")
	public String welcome() {
		System.out.println(cookieService.getValue("user",""));
		System.out.println(sessionService.get("username").toString());
		return "Welcome to back !!";
	}
}
