package com.calisma.hiberusing;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Users;
import util.EncryptionById;

@Controller
public class LoginController {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		// cookies control
		if (req.getCookies() != null) {
			Cookie[] cookies = req.getCookies();
			for (Cookie item : cookies) {
				if (item.getName().equals("user_remember")) {
					String uid = EncryptionById.sifreCoz(item.getValue(),4); 
					System.out.println("cookie id "+uid); 
					/* put id in session and redirect the user  */
					return "redirect:/";
				}
			}
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Users us, @RequestParam(defaultValue = "off") String remember_me, HttpServletResponse res) {
		System.out.println("rememberme " + remember_me);
		Session sesi = sf.openSession();
		/*try catch used prevent 500 error when unregistered users try login */
		try {
			Users lus = (Users) sesi.createQuery("from Users where umail = ? and upassword = ?")
					.setParameter(0, us.getUmail())
					.setParameter(1, us.getUpassword())
					.list() 																			
					.get(0);
			System.out.println("name: " + lus.getUname());
			// Login successful
			if (remember_me.equals("on")) {	
				/*if remember checkbox checked you do not go to the login page again. */
				Cookie cookie = new Cookie("user_remember", EncryptionById.sifrele("" + lus.getUid(), 4));
				/*session created by id. Encryption provide show complex characters in cookie values*/																					// session
																									
				cookie.setMaxAge(60 * 60 * 24); //1 day
				res.addCookie(cookie);
				
			}
		} catch (Exception e) {
			System.err.println("unregistered user" + e);
			return "redirect:/login";
		}

		return "redirect:/";
	}

	// exit, trigger request 
	// cookie delete
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(HttpServletResponse res) {
		//	 http://localhost:8280/hiberusing/exit  kill cookie
		Cookie cookie = new Cookie("user_remember", "");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		return "redirect:/";
	}
}
