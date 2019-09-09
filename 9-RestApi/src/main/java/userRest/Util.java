package userRest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Util {

	public static boolean apiControl(String apiKey, DB db) {

		boolean statu = false;
		if(apiKey.equals("")) {
			return false;
		}
		try {
			String query = "select * from admin where api_key = ? ";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, apiKey);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				statu = true;
				int aid=rs.getInt("aid");
				int count=rs.getInt("count");
				count+=1;
				String q = "update admin set count = ? where aid = ?";
				PreparedStatement pr=db.connect(q);
				pr.setInt(1,count);
				pr.setInt(2, aid);
				pr.executeUpdate();
			}
		} catch (Exception e) {
			System.err.println("ApiKey error " + e);
		}
		return statu;
	}
}
