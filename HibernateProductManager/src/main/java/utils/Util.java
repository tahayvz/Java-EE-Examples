package utils;

import javax.servlet.http.HttpServletRequest;

public class Util {

	
	public static String control( HttpServletRequest req, String page ) {
		
		//http://localhost:8080/sessioncontrol/dashboard  to prevent direct opening this link used statu boolean

		
		boolean statu = req.getSession().getAttribute("user_id") != null;
		if(statu) {		
			return page;		
		}
		return "redirect:/";
	}
	
	
	
}
