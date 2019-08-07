package com.calisma.hiberusing;

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
import model.Users;

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
		
		List<Users> ls = sesi.createQuery("from Users").list();
		model.addAttribute("data", ls);

		return "home";
	}

	@RequestMapping(value = "/userInsert", method = RequestMethod.POST)
	public String userInsert(Users us) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		int id = (Integer) sesi.save(us);
		if (id > 0) {
			// added success
		}
		tr.commit();

		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String userDelete(@PathVariable int userId) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction(); // should be used when edit, remove, insert
		Users us = sesi.load(Users.class, userId);

		sesi.delete(us);
		tr.commit();
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String edit(@PathVariable int userId, Model model) {
		// no transaction required in select operation
		editID=userId;
		Session sesi = sf.openSession();
		Users us = sesi.load(Users.class, userId);
		model.addAttribute("us", us);

		return "home";
	}
	
	@RequestMapping(value = "/edit/userEdit", method = RequestMethod.POST)
	public String userEdit(Users us) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction(); 
		us.setUid(editID);
		sesi.update(us);
		tr.commit();
		return "redirect:/";
	}

}
