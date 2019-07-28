package com.calisma.dbconnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.DB;
import util.UserPro;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	DB db=new DB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {	
		model.addAttribute("data",dataResult());		
		return "home";
	}
	
	//insert into database
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insert(UserPro us) {
		try {
			String query="INSERT INTO `users`(`uid`, `uname`, `usurname`, `umail`, `upassword`, `uresim`, `uprice`) VALUES (null,?,?,?,?,?,?)";
			PreparedStatement pre= db.connect(query); 
			pre.setString(1, us.getUname());
			pre.setString(2, us.getUsurname());
			pre.setString(3, us.getUmail());
			pre.setString(4, us.getUpassword());
			pre.setString(5, us.getUresim());
			pre.setString(6, us.getUprice());
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("insert error: "+ e);
		}	
		return "redirect:/"; 
		//redirect used when used add, delete, set operations. if use return "home" doesn't appear last added data when pressed submit
	}
	
	//take from database add list
	public List<UserPro> dataResult(){ 	
		List<UserPro> ls= new ArrayList<UserPro>();
		try {
			String query="SELECT * FROM `users`";	 
			PreparedStatement pre=db.connect(query);
			ResultSet rs= pre.executeQuery(); //we can consume all queries. This method returns the object of ResultSet that can be used to get all the records of a table.
			while(rs.next()) { //retrieves data every step in the database. rs.next() is used to move the cursor to the one row next from the current position.
				int uid= rs.getInt("uid"); //rs goes to database calls the first uid
				String uname=rs.getString("uname");
				String usurname=rs.getString("usurname");
				String umail=rs.getString("umail");
				String upassword=rs.getString("upassword");
				String uresim=rs.getString("uresim");
				String uprice=rs.getString("uprice");

				UserPro us=new UserPro();
				us.setUid(uid);
				us.setUname(uname);
				us.setUsurname(usurname);
				us.setUmail(umail);
				us.setUpassword(upassword);
				us.setUresim(uresim);
				us.setUprice(uprice);

				ls.add(us);
			}
		} catch (Exception e) {
		System.err.println("select error: " + e);
		}
		return ls;
	} 

	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {	//Since java is going to the outside again, we use try catch
		try {
			String query="DELETE FROM `users` WHERE `users`.`uid` = ?"; //press delete button in database, copy output
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
		return "redirect:/";
	}
}
