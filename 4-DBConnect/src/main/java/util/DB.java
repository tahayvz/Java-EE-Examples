package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
	
	
	//needed this 4 for database
	final private String url ="jdbc:mysql://localhost/"; //jdbc ve mysqle baglanarak localhosta git
	final private String dbName ="proje_ee"; //baðlanýlacak veritabanýnýn yolu
	final private String dbUser ="root"; //default olarak kullanýcý adý root sifre verilmez xampp ile admine basýnca verilir
	final private String dbPass ="";
	
	final private String driver="com.mysql.jdbc.Driver";//maven dependencies mysql-connector icinde class.forname ile driver.class çaðrýlýnca mysql tetiklenir 
	//connection sýnýfý olmadan jdbc ye bagkanýlamaz
	//java.sql kullanýrsak projeyi oracle a tasimak kolay olur
	
	private Connection con= null;
	private PreparedStatement st;
	public DB() { //the object works as soon as it is handled	
		try {
			Class.forName(driver); //triggered library
			con = DriverManager.getConnection(url+dbName,dbUser, dbPass);
			System.out.println("baglanti basarili");
		} catch (Exception e) {
			System.err.println("Baglanti hatasi: " + e);
		}
	}
	//Since java is going to the mysql there may be risk from outside so we use try catch
	
/**
	 * Bu fonksiyon vertabanýna baðlanmak için gereklidir.
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
	