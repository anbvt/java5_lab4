package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.model.DB;

@Controller
public class ProductController {
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("items", DB.Products.values());
		return "product/index";
	}
}
