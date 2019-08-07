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
public class DashBoardController {

	DB db=new DB();
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpServletRequest req) {
		model.addAttribute("catData", catResult());
		IncluderController.page="dashboard";
		return Util.control(req, "dashboard");
	}


		
	public List<CategoryPro> catResult() {
		List<CategoryPro> ls = new ArrayList<CategoryPro>();
			try {
				String query = "select * from categories";
				PreparedStatement pre = db.connect(query);
				ResultSet rs = pre.executeQuery();
				while(rs.next()) {
					int cid = rs.getInt("cid");
					String ctitle = rs.getString("ctitle");
					
					CategoryPro ct = new CategoryPro();
					ct.setCid(cid);
					ct.setCtitle(ctitle);
					
					ls.add(ct);
					
				}
			} catch (Exception e) {
				System.err.println("sql error : " + e);
			}
		return ls;
	}
	
	@RequestMapping(value = "/cartInsert", method = RequestMethod.POST)
	public String cartInsert(Carts cr,HttpServletRequest req) {
		try {
			String query = "INSERT INTO `cart` (`crid`, `cmail`, `cpassword`, `cname`, `csurname`, `cphone`, `cid`, `cnote`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, cr.getCmail());
			pre.setString(2, cr.getCpassword());
			pre.setString(3,cr.getCname());
			pre.setString(4, cr.getCsurname());
			pre.setString(5, cr.getCphone());
			pre.setInt(6, cr.getCid());
			pre.setString(7, cr.getCnote());
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("insert hatasý : " + e);
		}
		return Util.control(req, "redirect:/dashboard");
	}
	
	
	
	// exit call
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(HttpServletRequest req) {
		req.getSession().removeAttribute("user_id");
		req.getSession().invalidate(); // delete all session
		return "redirect:/";
	}
	
}

