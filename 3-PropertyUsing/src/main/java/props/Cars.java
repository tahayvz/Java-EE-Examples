package props;

public class Cars {

	public Cars() {
		System.out.println("page opened");
	} 
	public Cars(String data) {
		
	}
	
	//property defined private because protect variable from 3th party application
	private String title;
	private int price;
	private String img;
	private int id;
	private String durum;
	
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	
}
