package com.calisma.sessioncontrolproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.Util;

@Controller
public class UpdatePageController {
	
	DB db = new DB();

	@RequestMapping(value = "/updatePage/{crid}", method = RequestMethod.GET)
	public String updatePage( @PathVariable int crid, Model model, HttpServletRequest req ) {
		req.getSession().setAttribute("crid", crid);
		model.addAttribute("tablePro", tableResult(crid));
		model.addAttribute("catData", new DashBoardController().catResult());
		System.out.println("crid : " + crid);
		IncluderController.page="update";

		return Util.control(req, "update");
	}
	
	
	public TablePro tableResult(int crid) {
		
		try {
			String query = "SELECT * FROM cart c INNER JOIN categories as ct ON c.cid = ct.cid where c.crid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, crid);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				TablePro pr = new TablePro();
				pr.setCmail(rs.getString("cmail"));
				pr.setCpassword(rs.getString("cpassword"));
				pr.setCname(rs.getString("cname"));
				pr.setCphone(rs.getString("cphone"));
				pr.setCrid(rs.getInt("crid"));
				pr.setCsurname(rs.getString("csurname"));
				pr.setCtitle(rs.getString("ctitle"));
				pr.setCid(rs.getInt("cid"));
				pr.setCnote(rs.getString("cnote"));
				return pr;
			}
		} catch (Exception e) {
			System.err.println("tableResult error : " + e);
		}
		return null;
	}
	
	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String cartUpdate( TablePro tbl, HttpServletRequest req ) {
		int crid = Integer.valueOf(""+req.getSession().getAttribute("crid"));
		
		try {
			String query = "update cart set cmail = ?, cpassword = ?, cname = ?, csurname = ?, cphone = ?, cid = ?, cnote = ? where crid = ? ";
			PreparedStatement pre = db.connect(query);
			
			pre.setString(1, tbl.getCmail());
			pre.setString(2, tbl.getCpassword());			
			pre.setString(3, tbl.getCname());
			pre.setString(4, tbl.getCsurname());
			pre.setString(5, tbl.getCphone());
			pre.setInt(6, tbl.getCid());
			pre.setString(7, tbl.getCnote());
			pre.setInt(8, crid);
			
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("update error : " + e);
		}
		
		return Util.control(req, "redirect:/settings");
	}
	
	
	
}
