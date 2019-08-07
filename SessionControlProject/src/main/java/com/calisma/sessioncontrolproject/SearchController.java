package com.calisma.sessioncontrolproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	DB db=new DB();
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public String search(@RequestParam String q, Model model) {
		
		List<TablePro> ls=new ArrayList<TablePro>();
		
		try {
			String query="select * from cart where cname like ? or csurname like ? or cphone like ?";
			PreparedStatement pre= db.connect(query);
			pre.setString(1, "%"+q+"%");
			pre.setString(2, "%"+q+"%");		
			pre.setString(3, "%"+q+"%");
			
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				int crid=rs.getInt("crid");
				String cname=rs.getString("cname");
				String csurname=rs.getString("csurname");
				String cphone=rs.getString("cphone");
				
				TablePro cr=new TablePro();
				cr.setCname(cname);
				cr.setCphone(cphone);
				cr.setCsurname(csurname);
				cr.setCrid(crid);
				
				ls.add(cr);
			}
		} catch (Exception e) {
			System.err.println("sql error: "+ e);
		}
		model.addAttribute("ls",ls);
		IncluderController.page="search";

		return "search";
	}
}
