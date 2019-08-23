package model;
// Generated 15.A�u.2019 10:53:15 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Adminuser generated by hbm2java
 */
@Entity
@Table(name = "adminuser")
public class Adminuser implements java.io.Serializable {

	private Integer aid;
	private String amail;
	private String apassword;

	public Adminuser() {
	}

	public Adminuser(String amail, String apassword) {
		this.amail = amail;
		this.apassword = apassword;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "amail", nullable = false)
	public String getAmail() {
		return this.amail;
	}

	public void setAmail(String amail) {
		this.amail = amail;
	}

	@Column(name = "apassword", nullable = false)
	public String getApassword() {
		return this.apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

}
