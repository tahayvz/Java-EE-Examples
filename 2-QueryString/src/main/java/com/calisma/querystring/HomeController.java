package com.calisma.querystring;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	/* //both get and post work in this request
	
	@RequestMapping(value = "/")
  	public String fncHomePst(Model model) {
	model.addAttribute("data", dataResult());
	return "home";
	}*/
	
	// index fnc call
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fncHome(Model model) {
		model.addAttribute("data", dataResult()); //data is just name used in home.jsp
		model.addAttribute("datatwo", proglang());
		return "home";

	}
	
	/* @RequestMapping(value = "/", method = RequestMethod.POST)
	 * post required for sending password and when make post first this request run so firstly looking 
	 * post or get if not then lookig to undefined request @RequestMapping(value = "/")  run.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String fncHomePst(Model model, @RequestParam String mail, 
			@RequestParam String password) { 	//mail and password names be included in home.jsp in post form

		if(mail.equals("")) {
			model.addAttribute("fail", "Lütfen mail adresi giriniz");
		}else if (password.equals("")) {
			model.addAttribute("fail", "Lütfen þifre giriniz");
		}else {
			System.out.println("mail : "+ mail + " password: " + password);
		if(mail.equals("taha@yavuz.com") && password.equals("123")) {
				// redirect page
				return "redirect:/detail/taha@yavuz.com";
		}else {
				model.addAttribute("fail", "Kullanýcý adý yada þifre hatalý!");
			}
		}
		model.addAttribute("data", dataResult()); 
		model.addAttribute("datatwo", proglang());

		/* when made post this line again call dataresult(). If this line become comment line then firstly 
		   arraylist come with get method but when calling post method arraylist is not shown. Because in post
		   there is not dataresult() attribute 
		*/
		
		return "home";
	}
	
	
	// data result
	public ArrayList<String> dataResult() {
		ArrayList<String> ls = new ArrayList<String>();
			// data add
			ls.add("Burma Kadayif");
			ls.add("Peynirli Kunefe");
			ls.add("Fistikli Baklava");
			ls.add("Maras Dondurma");
		return ls;
	}
	
	public ArrayList<String> proglang() {
		ArrayList<String> ls=new ArrayList<String>();
			ls.add("Cay");
			ls.add("Kola");
			ls.add("Soda");
		return ls;
	}
	

}
