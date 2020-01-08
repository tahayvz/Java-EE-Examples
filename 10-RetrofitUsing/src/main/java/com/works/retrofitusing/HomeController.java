package com.works.retrofitusing;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import restUsing.API;
import restUsing.Bilgiler;
import restUsing.JsonPro;
import restUsing.Service;
import retrofit2.Call;

@Controller
public class HomeController {
		
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws IOException {
	
		//override Service interface by retrofit 
		Service service = API.getClient().create(Service.class);
		//dt object keep overrides
		Call<JsonPro> dt = service.allUser();
		List<Bilgiler> ls=  dt.execute().body().getProducts().get(0).getBilgiler();


		model.addAttribute("ls",ls);

		/*  
	 	//add all request within service to the queue
		dt.enqueue(new Callback<JsonPro>() {
			
			@Override
			public void onResponse(Call<JsonPro> call, Response<JsonPro> response) {
				JsonPro pr = response.body(); //pr keep datas in object form 
				//java ee de string ifadelerden uzak durmak gerekir bu y�zden objelerle productname vs yakalan�r
//				String name = pr.getProducts().get(0).getBilgiler().get(0).getProductName(); //getProducts(),getBilgiler() and getProductName() are arrays. get(0) call first array
//			System.out.println(name);
			List<Bilgiler> ls = pr.getProducts().get(0).getBilgiler();
			model.addAttribute("ls",ls);
//			for(Bilgiler item: ls) {
//				System.out.println(item.getProductName());
//			}
			}
			
			@Override
			public void onFailure(Call<JsonPro> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		return "home";
	}
	
}