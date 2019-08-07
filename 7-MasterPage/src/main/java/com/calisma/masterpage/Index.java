package com.calisma.masterpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		IncluderController.page="/";
		
		return "index";
	}
	
}
