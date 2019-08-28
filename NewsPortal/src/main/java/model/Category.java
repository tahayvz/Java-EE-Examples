package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	private int ctid;
	private String ctname;
	
	public Category() {
	}
	public Category(String ctname) {
		this.ctname = ctname;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "ctid", unique = true, nullable = false)
	public Integer getCtid() {
		return this.ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	
	@Column(name = "ctname", unique = true, nullable = false)
	public String getCtname() {
		return this.ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}
}

