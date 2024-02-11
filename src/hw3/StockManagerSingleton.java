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
	
	public ArrayList<MediaProduct> getMediaPRoductBelowPrice(int maxPrice){
		/* - gets media products that are below given price
		 * - creates a new arraylist of media products that is below maxprice
		 *  - don't leak info
		 */
		
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		/* - create a newArrayList of Vinyls that returns the Vinyl products as a list
		 * - don't leak info
		 */
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList){
		/* - create a newArrayList of CDs that returns the CD products as a list
		 * - don't leak info
		 */
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		/* - create a newArrayList of tapes that returns the tape products as a list
		 * - don't leak info
		 */
	}
	
	
	
	
	
	
	
	
	
}
