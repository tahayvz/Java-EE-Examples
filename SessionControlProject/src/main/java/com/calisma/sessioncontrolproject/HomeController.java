package com.calisma.sessioncontrolproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import utils.Util;


@Controller
public class HomeController {
	
	DB db = new DB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model,HttpServletRequest req) {
		return "home";	
	}
	
	


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String mail, @RequestParam String password, HttpServletRequest req) {
	
		try {
		String query = "select * from cart";
		PreparedStatement pre = db.connect(query);
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			String cmail = rs.getString("cmail");
			String cpassword = rs.getString("cpassword");
		
		
		
		if(mail.equals(cmail) && password.equals(cpassword)) 
		{
			// session create
			req.getSession().setAttribute("user_id", 10);

			return "redirect:/dashboard"; 
		}
		}
		}
		catch (Exception e) {
			System.err.println("login  error : " + e);
		}
		return "redirect:/";
	
		}
	}
	