package com.calisma.sessioncontrolproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.Util;

@Controller
public class FamilyController {

	DB db= new DB();
	
	@RequestMapping(value="/family", method= RequestMethod.GET)
	public String allContact(Model model, HttpServletRequest req) {
		model.addAttribute("tableData", tableResult());
		return Util.control(req, "family");
	}
	
	// table result
	public List<TablePro> tableResult() {
		List<TablePro> ls = new ArrayList<TablePro>();
		try {
			String query = "SELECT * FROM cart c INNER JOIN categories as ct ON c.cid = ct.cid ORDER by c.crid ASC";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				TablePro pr = new TablePro();
				pr.setCmail(rs.getString("cmail"));
				pr.setCpassword(rs.getString("cpassword"));				
				pr.setCname(rs.getString("cname"));
				pr.setCphone(rs.getString("cphone"));
				pr.setCrid(rs.getInt("crid"));
				pr.setCsurname(rs.getString("csurname"));
				pr.setCtitle(rs.getString("ctitle"));
				pr.setCnote(rs.getString("cnote"));
				pr.setCid(rs.getInt("cid"));
				ls.add(pr);
			}
		} catch (Exception e) {
			System.err.println("tableResult error : " + e);
		}
		return ls;
	}
}
