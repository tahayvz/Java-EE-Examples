package com.calisma.newsportal;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.News;
import utils.Util;

@Controller
public class GuestNewsDetailPageController {

	SessionFactory sf=HibernateUtil.getSessionFactory();
	
	@RequestMapping(value="/guestnews/{userId}", method = RequestMethod.GET)
	public String newsDetailPage(@PathVariable int userId, Model model, HttpServletRequest req) {
		Session sesi = sf.openSession();
		News news = sesi.load(News.class, userId);
		model.addAttribute("data", news);
		return Util.control(req, "guestNewsDetailPage");
	}
		
}
