package com.calisma.newsportal;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.News;
import utils.Util;

@Controller
public class SearchController {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam String q,HttpServletRequest req) {
		Session session = sf.openSession();
		List<News> ls = session.createQuery("from News WHERE ntext like ? or ntexttwo like ? or ntitle like ? order by nid desc")
			.setParameter(0, "%"+q+"%")
			.setParameter(1, "%"+q+"%")
			.setParameter(2, "%"+q+"%")
			.list();
		model.addAttribute("data", ls);
		return Util.control(req, "newsPage");

		
			

	}	
}