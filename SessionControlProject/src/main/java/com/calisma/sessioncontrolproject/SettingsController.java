package com.calisma.sessioncontrolproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.Util;

@Controller
public class SettingsController {
DB db=new DB();
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings(Locale locale, Model model, HttpServletRequest req) {
		model.addAttribute("tableData", tableResult());
		return Util.control(req, "settings"); 
		// if use return "settings"; then go to http://localhost:8280/sessioncontrol/settings page will open so does not require password
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
				ls.add(pr);
			}
		} catch (Exception e) {
			System.err.println("tableResult error : " + e);
		}
		return ls;
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {	//Since java is going to the outside again, we use try catch
		try {
			String query="DELETE FROM `cart` WHERE `cart`.`crid` = ?"; //press delete button in database, copy output
			PreparedStatement pre=db.connect(query); //query is used for select only
			pre.setInt(1, id ); //1 is first question mark, second is uid 
			int statu=pre.executeUpdate(); //freezes the rows affected.is used to execute specified query, it may be create, drop, insert, update, delete etc.
			if(statu>0) {
				System.out.println("sime islemi basarili");
			}
			else {
				System.out.println("silme hatasý");//run if can not reach id
			}
		} catch (Exception e) {
		System.err.println("delete error: "+ e); //for example, if the string in the query is incorrectly written here this will print
		}
		return "redirect:/settings";
	}
}
