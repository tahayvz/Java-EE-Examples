package com.calisma.querystring;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	// index fnc call
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fncHome(Model model) {
		model.addAttribute("data", dataResult());
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
			model.addAttribute("fail", "L�tfen mail adresi giriniz");
		}else if (password.equals("")) {
			model.addAttribute("fail", "L�tfen �ifre giriniz");
		}else {
			System.out.println("mail : "+ mail + " password: " + password);
			if(mail.equals("ali@ali.com") && password.equals("12345")) {
				// redirect page
				return "redirect:/detail/ali@ali.com";
			}else {
				model.addAttribute("fail", "Kullan�c� ad� yada �ifre hatal�!");
			}
		}
		model.addAttribute("data", dataResult()); //this line show arraylist 
		
	

		return "home";
	}
	
	/* //both get and post work in this request
		
		@RequestMapping(value = "/")
	  	public String fncHomePst(Model model) {
		model.addAttribute("data", dataResult());
		return "home";
		}
	 */
	
	// data result
	public ArrayList<String> dataResult() {
		ArrayList<String> ls = new ArrayList<String>();
			// data add
			ls.add("Burma Kaday�f");
			ls.add("Peynirli K�nefe");
			ls.add("F�st�kl� Baklava");
			ls.add("Mara� Dondurmas�");
			ls.add("Urfa Ka�ak �ay");
		return ls;
	}
	

}
