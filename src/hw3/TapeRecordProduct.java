package hw3;

public class TapeRecordProduct extends MediaProduct{

	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}

	@Override
	public String toString() {
	    return "Tape Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
	}
}
