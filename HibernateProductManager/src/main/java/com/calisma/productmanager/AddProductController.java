package com.calisma.productmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Products;

@Controller
public class AddProductController {
	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct() {

		return "addProduct";
	}
	
	
	@RequestMapping(value = "/userInsert", method = RequestMethod.POST)
	public String userInsert(Products pro) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		int id = (Integer) sesi.save(pro);
		if (id > 0) {
			// added success
		}
		tr.commit();

		return "redirect:/";
	}	
	
}
