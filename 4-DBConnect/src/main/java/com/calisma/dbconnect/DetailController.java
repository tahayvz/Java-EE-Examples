package com.calisma.dbconnect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.DB;

@Controller
public class DetailController {
	DB db=new DB();

	@RequestMapping(value ="/detail/{param}", method = RequestMethod.GET)
	public String detail( @PathVariable int param, Model model ) {
		System.out.println("Param " + param);
		model.addAttribute("title", param);
		
		return "detail";
	}

	@RequestMapping(value="/detail/{id}", method=RequestMethod.POST)
	public String update(@PathVariable int id) {	

		
		
		return "redirect:/";
	}
	
	
}