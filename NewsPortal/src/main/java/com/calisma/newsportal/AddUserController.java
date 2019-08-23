package com.calisma.newsportal;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Adminuser;

@Controller
public class AddUserController {
int editID;
	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model, HttpServletRequest req) {
		return  "addUser";
	}

	@RequestMapping(value = "/userinsert", method = RequestMethod.POST)
	public String userInsert(Adminuser au) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		int id = (Integer) sesi.save(au);
		if (id > 0) {
			// added success
		}
		tr.commit();

		return "redirect:/";
	}
}