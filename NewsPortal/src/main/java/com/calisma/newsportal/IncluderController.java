package com.calisma.newsportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncluderController {

	public static String page="/";
	
	// css
	@RequestMapping(value = "/css", method = RequestMethod.GET)
	public String css() {

		return "inc/css";
	}

	// js
	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public String js() {

		return "inc/js";
	}

	// footer
	@RequestMapping(value = "footer", method = RequestMethod.GET)
	public String footer() {

		return "inc/footer";
	}
	
	// navbar
	@RequestMapping(value = "navbar", method = RequestMethod.GET)
	public String navbar(Model model) {

		model.addAttribute("page",IncluderController.page);
		return "inc/navbar";
	}
	
	// guest navbar
		@RequestMapping(value = "guestnavbar", method = RequestMethod.GET)
		public String guestnavbar(Model model) {

			model.addAttribute("guestpage",IncluderController.page);
			return "inc/guestnavbar";
		}
		
	// exit
		@RequestMapping(value = "/exitfunc", method = RequestMethod.GET)
		public String exit() {

			return "inc/exitfunc";
		}
}
