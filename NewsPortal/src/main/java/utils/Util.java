package utils;

import javax.servlet.http.HttpServletRequest;

public class Util {

	
	public static String control( HttpServletRequest req, String page) {
		
		//sesion control		
		boolean statu = req.getSession().getAttribute("admin") != null;
		boolean statuguest = req.getSession().getAttribute("misafir") != null;
		if(statu || statuguest) {		
			return page;		
		}
		
		return "redirect:/";
	}
	
	/*
	public static String controlAdmin( HttpServletRequest req, String page) {
		
		//sesion control		
		boolean statu= req.getSession().getAttribute("amail") != null;
		if(statu) {		
			return page;		
		}
		return "redirect:/";
	}*/
}
