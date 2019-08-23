package com.calisma.productmanager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Products;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UpdateProductController {
int editID;
	SessionFactory sf = HibernateUtil.getSessionFactory(); // connection is established

	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public String updateProduct(Model model) {

		Session sesi = sf.openSession(); 
		
		List<Products> ls = sesi.createQuery("from Products").list();
		model.addAttribute("data", ls);

		return "updateProduct";
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String userDelete(@PathVariable int userId) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction(); // should be used when edit, remove, insert
		Products pro = sesi.load(Products.class, userId);

		sesi.delete(pro);
		tr.commit();
		return "redirect:/";
	}

	
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String edit(@PathVariable int userId, Model model) {
		// no transaction required in select operation
		editID=userId;
		Session sesi = sf.openSession();
		Products pro = sesi.load(Products.class, userId);
		model.addAttribute("pro", pro);

		return "updateProduct";
	}
	
	@RequestMapping(value = "/edit/userEdit", method = RequestMethod.POST)
	public String userEdit(Products pro) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction(); 
		pro.setPid(editID);
		sesi.update(pro);
		tr.commit();
		return "redirect:/";
	
	}
	

}
