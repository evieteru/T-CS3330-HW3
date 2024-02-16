package hw3;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		
	}
	
	@Override
	public String toString() {
	    return "Vinyl Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
	}
			
}
