package com.calisma.querystring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {
	
	//output for console
	
	@RequestMapping(value = "/detail/{param}", method = RequestMethod.GET)
	public String fncDetail( @PathVariable String param, Model model ) {
		System.out.println("Param " + param);
		model.addAttribute("title", param);
		if(param.equals("Maras Dondurma")) {
			model.addAttribute("listDondurma", dondurma());
		}
		return "detail";
	}

	
	public ArrayList<String> dondurma() {
		ArrayList<String> ls=new ArrayList<String>();
			ls.add("sutlu");
			ls.add("cikolatali");
			ls.add("meyveli");
		return ls;
	}
	}