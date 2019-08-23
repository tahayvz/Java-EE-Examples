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

import model.News;
import utils.Util;

@Controller
public class EditNewsController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/editNews", method = RequestMethod.GET)
	public String editNews(Model model, HttpServletRequest req) {

		// no transaction required in select operation
		Session sesi = sf.openSession();
		List<News> ls = sesi.createQuery("from News").list();
		model.addAttribute("data", ls);

		return Util.control(req, "editNews");

	}



}
