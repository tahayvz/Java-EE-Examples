package utils;

import javax.servlet.http.HttpServletRequest;

public class Util {

	
	public static String control( HttpServletRequest req, String page) {
		
		//sesion control		
		boolean statu = req.getSession().getAttribute("admin") != null;
		if(statu ) {		
			return page;		
		}
		
		return "redirect:/";
	}

public static String controlguest( HttpServletRequest req, String page) {
		
		//sesion control		
		boolean statuguest = req.getSession().getAttribute("misafir") != null;
		if(( statuguest)) {		
			return page;		
		}
		
		return "redirect:/";
	}
}
