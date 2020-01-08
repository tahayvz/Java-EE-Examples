package com.calisma.newsportal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.News;
import utils.Util;

@Controller
public class AddNewsController {
int editID;
	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value = "addNews", method = RequestMethod.GET)
	public String addNews(Model model, HttpServletRequest req) {
		IncluderController.page="addNews";
		Session session = sf.openSession();
		List<Category> cls = session.createQuery("from Category").list();
		model.addAttribute("ctgData", cls);
//		return Util.control(req, "addNews");
		return "addNews";
	}

	@RequestMapping(value = "/newinsert", method = RequestMethod.POST)
	public String userInsert(News us, HttpServletRequest req) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		int id = (Integer) sesi.save(us);
		if (id > 0) {
			// added success
		}
		tr.commit();

		return Util.control(req, "redirect:/news");
	}
}