package com.calisma.retrofitusing;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import restUsing.API;
import restUsing.Bilgiler;
import restUsing.JsonPro;
import restUsing.Service;
import retrofit2.Call;

@Controller
public class DetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */	
	@RequestMapping(value = "/detail/{productid}", method = RequestMethod.GET)
	public String detail(@PathVariable int productid, Model model) throws IOException {
	
		//override Service interface by retrofit 
		Service service = API.getClient().create(Service.class);
		//dt object keep overrides
		Call<JsonPro> dt = service.allUser();
		List<Bilgiler> ls=  dt.execute().body().getProducts().get(0).getBilgiler();


		model.addAttribute("ls",ls);

	
		
		return "detail";
	}
	
}
