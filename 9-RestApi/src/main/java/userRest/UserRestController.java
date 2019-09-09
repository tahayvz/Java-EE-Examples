package userRest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {
	/*
	 * @controller return string or jsp. @restcontroller return file that json format
	 */
	DB db = new DB();
	//all user rest -> json
	//return HashMap<String, Object> ?
	
	@RequestMapping(value="/allCustomer", method=RequestMethod.GET)
	public HashMap<String, Object> allCustomer(@RequestParam(defaultValue = "") String apiKey){
		HashMap<String, Object> hm=new HashMap<>();
		//for null apikey 
		if(!Util.apiControl(apiKey, db)) { 
			hm.put("message", "API key gereklidir");
			return hm;
		}
		
		System.out.println("apiKey " +apiKey);
		List<CustomerPro> ls=dataResult();
		if(ls.size()==0) {
			hm.put("statu", false);
			hm.put("message", "kullanıcı listenizde üye yok");
		}
		hm.put("statu", true);
		hm.put("message", "kullanıcı başarıyla listelendi");
		hm.put("count", ls.size()); 
		hm.put("customers", ls);
		return hm;
		
	}
	
	public List<CustomerPro> dataResult() {
		List<CustomerPro> ls = new ArrayList<CustomerPro>();

		try {
			String query = "select * from customer";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				CustomerPro cr = new CustomerPro();
				cr.setCustomer_id(rs.getInt("customer_id"));
				cr.setFirst_name(rs.getString("first_name"));
				cr.setLast_name(rs.getString("last_name"));
				cr.setEmail(rs.getString("email"));
				ls.add(cr);
			}
		} catch (Exception e) {
			System.err.println("Data result error " + e);
		}

		return ls;

	}

}
