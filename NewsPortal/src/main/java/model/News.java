package model;
// Generated 12.A�u.2019 15:01:06 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * News generated by hbm2java
 */
@Entity
@Table(name = "news")
public class News implements java.io.Serializable {

	private Integer nid;
	private String ntitle;
	private String nurl;
	private String ntext;
	private String ntexttwo;

	public News() {
	}

	public News(String ntitle, String nurl, String ntext, String ntexttwo) {
		this.ntitle = ntitle;
		this.nurl = nurl;
		this.ntext = ntext;
		this.ntexttwo = ntexttwo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "nid", unique = true, nullable = false)
	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@Column(name = "ntitle", nullable = false)
	public String getNtitle() {
		return this.ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	@Column(name = "nurl", nullable = false)
	public String getNurl() {
		return this.nurl;
	}

	public void setNurl(String nurl) {
		this.nurl = nurl;
	}

	@Column(name = "ntext", nullable = false)
	public String getNtext() {
		return this.ntext;
	}

	public void setNtext(String ntext) {
		this.ntext = ntext;
	}
	
	@Column(name = "ntexttwo", nullable = false)
	public String getNtexttwo() {
		return this.ntexttwo;
	}

	public void setNtexttwo(String ntexttwo) {
		this.ntexttwo = ntexttwo;
	}

}
