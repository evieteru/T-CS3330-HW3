package hw3;
import java.util.*;

public class StockManagerSingleton {

	private String inventoryFilePath; //must be closed for modification

	
	//Getter and Setter
	public String getInventoryFilePath() {
		return inventoryFilePath;
	}

	public void setInventoryFilePath(String inventoryFilePath) {
		this.inventoryFilePath = inventoryFilePath;
	}
	
	
	//Methods ---------------------------------------------------------
	
	public boolean initializeStock() {
		/* - read data from CSV file
		 * - parse file, create MediaProduct items, add to inventory
		 * - return true for success
		 */
		
		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		return false;
	}
	
	public boolean addItem(MediaProduct product) {
		return false;
	}
	
	public boolean removeItem(MediaProduct product) {
		return false;
	}
	
	public boolean saveStock() {
		/*Saves updated info to the CSV file, overwrite existing file*/
		return false;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		/* - gets media products that are below given price
		 * - creates a new arraylist of media products that is below maxprice
		 *  - don't leak info
		 */
		
		ArrayList<MediaProduct> productsBelowPrice = new ArrayList<>();
		
		for (MediaProduct currentProduct : inventoryList) {
			if(currentProduct.getPrice() < maxPrice) {
				productsBelowPrice.add(currentProduct);
			}
		}
		
		return productsBelowPrice;	
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
		for (MediaProduct currentProduct : productList) {
			System.out.println(currentProduct.toString());
		}
		
	}
	
	/**
	 * Creates a new ArrayList of VinylRecordProduc product list that filters the vinyl records in media product list
	 * @param productList
	 * @return ArrayList of only the VinylRecordProduct in it. 
	 */
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
		ArrayList<VinylRecordProduct> vinylRecords = new ArrayList<VinylRecordProduct>();
		
		return vinylRecords;
	}
		
	/**
	 * Creates a new ArrayList of CDRecordProduct product list that filters the CD records in media product list
	 * @param productList
	 * @return ArrayList of only the CDRecordProduct in it. 
	 */
	public ArrayList<CDRecordProduct> getCDRecordProduct(ArrayList<MediaProduct> productList) {
		ArrayList<CDRecordProduct> CDRecords = new ArrayList<CDRecordProduct>();
		
		return CDRecords;
	}	
	
	/**
	 * Creates a new ArrayList of TapeRecordProduct product list that filters the tape records in media product list
	 * @param productList
	 * @return ArrayList of only the TapeRecordProduct in it. 
	 */
	public ArrayList<TapeRecordProduct> getTapeRecordProduct(ArrayList<MediaProduct> productList) {
		ArrayList<TapeRecordProduct> TapeRecords = new ArrayList<TapeRecordProduct>();
		
		return TapeRecords;
	}
}	
	
}
