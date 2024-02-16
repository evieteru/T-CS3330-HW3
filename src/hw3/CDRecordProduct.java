package hw3;

public class CDRecordProduct extends MediaProduct {

	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
	    return "CD Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
	}

}
