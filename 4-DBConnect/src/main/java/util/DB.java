package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
	
	
	//needed this 4 for database
	final private String url ="jdbc:mysql://localhost/"; //connect MySQL using JDBC and go to localhost
	final private String dbName ="proje_ee"; //database name
	final private String dbUser ="root"; //default username root 
	final private String dbPass ="";  //default password null
	
	final private String driver="com.mysql.jdbc.Driver";
	
	
	private Connection con= null;
	private PreparedStatement st; //The performance of the application will be faster if you use PreparedStatement interface because query is compiled only once.
	public DB() { //the object works as soon as it is handled	
		try {
			Class.forName(driver); //triggered MySQL library.The forName() method of Class class is used to register the driver class. This method is used to dynamically load the driver class.
			con = DriverManager.getConnection(url+dbName,dbUser, dbPass); //establish connection with the Oracle database
			System.out.println("baglanti basarili");
		} catch (Exception e) {
			System.err.println("Baglanti hatasi: " + e);
		}
	}
	
/**
	 * This function is necessary to connect to the database.
	 * @param <b>query</b>
	 * @return PreparedStatement
	 */
	public PreparedStatement connect(String query) {
		
		try {
			st=con.prepareStatement(query);
			return st;
		} catch (Exception e) {
			System.err.println("Pre St Hatasi: "+ e);
		}
		return st;
	}

}
	