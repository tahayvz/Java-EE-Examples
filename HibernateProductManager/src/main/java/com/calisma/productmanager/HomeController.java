package com.calisma.productmanager;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Products;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
int editID;
	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Session sesi = sf.openSession(); 
		
		List<Products> ls = sesi.createQuery("from Products").list();
		model.addAttribute("data", ls);

		return "home";
	}



}
