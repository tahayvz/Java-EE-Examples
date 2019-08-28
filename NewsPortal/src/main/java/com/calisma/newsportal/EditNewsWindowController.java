package com.calisma.newsportal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.News;
import utils.Util;

@Controller
public class EditNewsWindowController {

	int editID;
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/editNews/{userId}", method = RequestMethod.GET)
	public String editNewsWindow(@PathVariable int userId, Model model, HttpServletRequest req) {
		
		// no transaction required in select operation
		editID = userId;
		Session sesi = sf.openSession();
		News us = sesi.load(News.class, userId);
		model.addAttribute("us", us);
		Session session = sf.openSession();
		List<Category> cls = session.createQuery("from Category").list();
		model.addAttribute("ctgData", cls);

		return Util.control(req, "editNewsWindow");
	}

	@RequestMapping(value = "/editNews/userEdit", method = RequestMethod.POST)
	public String userEdit(News us, HttpServletRequest req) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		us.setNid(editID);
		sesi.update(us);
		tr.commit();

		return Util.control(req, "redirect:/news");
	}
}