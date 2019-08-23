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
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.calisma.newsportal.HibernateUtil;
import model.News;
import utils.Util;

@Controller
public class DeleteNewsController {

	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value="/deleteNews", method = RequestMethod.GET)
	public String deleteNews(Model model, HttpServletRequest req) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		List<News> ls = sesi.createQuery("from News").list();
		model.addAttribute("data", ls);
		return Util.control(req, "deleteNews");
		
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String deleteNew(@PathVariable int userId, HttpServletRequest req) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction(); 
		News news= sesi.load(News.class, userId);

		sesi.delete(news);
		tr.commit();
		return Util.control(req, "redirect:/deleteNews");
	}
}
