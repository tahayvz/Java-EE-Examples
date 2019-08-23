package com.calisma.productmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncluderController {

	public static String page="/";
	
	// navbar
	@RequestMapping(value = "navbar", method = RequestMethod.GET)
	public String navbar(Model model) {

		model.addAttribute("page",IncluderController.page);
		return "inc/navbar";
	}
	
	// js
	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public String js() {

		return "inc/js";
	}
}
