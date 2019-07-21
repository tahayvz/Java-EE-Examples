package com.calisma.propertyusing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import props.Cars;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	List<Cars> carlist = new ArrayList<Cars>(); 
	int count=0;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("data", carlist);
		return "home";
	}
	
	@RequestMapping(value="/carInsert", method=RequestMethod.POST)
	public String carInsert(Cars crs) {
		//System.out.println(crs.getTitle());
		count++;
		crs.setId(count);
		siralama();
		carlist.add(crs);
		return "redirect:/"; //redirect call requestMethod.GET. Redirect used for post just one time. If redirect not used, post is sent each time the page is refreshed.
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		carlist.remove(indexSearch(id));
		return "redirect:/";
	}
	
	
	public int indexSearch(int id) {
		int s=0;
		for(Cars item: carlist) {
			if(item.getId()==id) break; //exit for
			s++;
		}
		return s;
	}
	
		public void siralama() {
			   int temp;
			   for (int i = 0; i < count; i++) {
			    for (int j = i; j > 0; j--) {
			    	if(carlist.get(j)!=null) {
			     if (carlist.get(j).getPrice() < carlist.get(j-1).getPrice()) {
			    	 int x=carlist.get(j).getId();
			    	 int y=carlist.get(j-1).getId();
			      temp = carlist.get(j).getId();
			    
			      x=y;
			     y=temp;
			     carlist.get(j).setId(x);
			     carlist.get(j-1).setId(y);
			     }}
			    }
			   }
			 

		      }   		
		}

