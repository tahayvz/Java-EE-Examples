package com.calisma.newsportal;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}