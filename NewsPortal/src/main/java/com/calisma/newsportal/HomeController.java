package com.calisma.newsportal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import model.Adminuser;
import utils.EncryptionById;
import utils.Util;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	boolean adminbool=false;
	boolean guestbool=false;
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
		//navbar link control
		IncluderController.page="/";
		// cookies control
				if (req.getCookies() != null) {
					Cookie[] cookies = req.getCookies();
					for (Cookie item : cookies) {
						if (item.getName().equals("user_remember")) {
							//for trigger this method go to http://localhost:8280/newsportal/ 
							String uid = EncryptionById.sifreCoz(item.getValue(),4); 
							System.out.println("cookie id "+uid); 

							return "redirect:/news";
						}
					}
				}
				return "home";
			}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Adminuser au, @RequestParam(defaultValue = "off") String remember_me, HttpServletResponse res,HttpServletRequest req) {
	
		System.out.println("rememberme " + remember_me);
		Session sesi = sf.openSession();
		/*try catch used for prevent 500 error when unregistered users try login */
		try {
			
			Adminuser lus = (Adminuser) sesi.createQuery("from Adminuser where amail = ? and apassword = ?")
					.setParameter(0, au.getAmail())
					.setParameter(1, au.getApassword())
					.list() 																			
					.get(0);
			System.out.println("name: " + lus.getAmail());
			
			//prevent go to login page by cookie
			if (remember_me.equals("on")) {
				Cookie cookie = new Cookie("user_remember", EncryptionById.sifrele("" + lus.getAid(), 4));
				/*session created by id. Encryption provide show complex characters in cookie values*/																					// session
																									
				cookie.setMaxAge(60 * 60 * 24); //1 day
				res.addCookie(cookie);
			}
			// Login control for admin user
			if(lus.getAmail().equals("admin")) {
				adminbool=true;
				req.getSession().setAttribute("admin", lus.getAid());
				System.out.println("admin user id: "+ lus.getAid());
			}
			//Login control for guest user
			else{
				guestbool=true;
				req.getSession().setAttribute("misafir", lus.getAid());
				System.out.println("guest user id: "+ lus.getAid());
			
			}
		} catch (Exception e) {
			System.err.println("unregistered user " + e);
			return "redirect:/";
		}	
		//login successful
		if(adminbool) {
		return Util.control(req, "redirect:/news");
		}
		//login successful
		else if(guestbool) {
			return Util.control(req, "redirect:/guestnews");

		}
		//unregistered user
		return "redirect:/";
	}
	
	// exit, trigger request 
	// cookie delete
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(HttpServletRequest req,HttpServletResponse res) {
				Cookie cookie = new Cookie("user_remember", "");
				cookie.setMaxAge(0);
				res.addCookie(cookie);
				req.getSession().removeAttribute("user_id");//delete just user_id session
				req.getSession().invalidate(); // delete all session
				adminbool=false; 
				guestbool=false;
				System.out.println("exit");
				return "redirect:/";
	}
}
