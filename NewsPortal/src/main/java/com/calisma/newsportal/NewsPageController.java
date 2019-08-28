package com.calisma.newsportal;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.News;
import utils.Util;

@Controller
public class NewsPageController {

	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(Locale locale, Model model, HttpServletRequest req) {
		IncluderController.page="news";

		Session sesi = sf.openSession(); 
		
		List<News> ls = sesi.createQuery("from News order by nid desc").setMaxResults(20).list();
		model.addAttribute("data", ls);
		return Util.control(req, "newsPage");
	}
	
	@RequestMapping(value = "/categoryadmin/{ctg}", method = RequestMethod.GET)
	public String category(Model model, @PathVariable String ctg, HttpServletRequest req) {
		Session session = sf.openSession();
		Category cat = (Category) session.createQuery("from Category where ctname = ?")
				.setParameter(0, ctg)
				.list()
				.get(0);
				
		List<News> ls = session.createQuery("from News where ncid = ? order by nid desc")
				.setParameter(0, cat.getCtid())
				.setFirstResult(0)
				.setMaxResults(20)
				.list();
		model.addAttribute("data", ls);
		return Util.control(req, "newsPage");
	}
}