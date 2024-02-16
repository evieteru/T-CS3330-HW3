package hw3;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import hw3.CDRecordProduct;
import hw3.Genre;
import hw3.MediaProduct;
import hw3.TapeRecordProduct;
import hw3.VinylRecordProduct;

public class StockManagerSingleton {

	private final static String inventoryFilePath = "files/inventory.csv"; //must be closed for modification
	ArrayList<MediaProduct> Inventory = new ArrayList<>();
	
	//Getter and Setter
	public String getInventoryFilePath() {
		return inventoryFilePath;
	}

	public void setInventoryFilePath(String inventoryFilePath) {
		this.inventoryFilePath = inventoryFilePath;
	}
	
	public ArrayList<MediaProduct> getInventoryArray() {
		return Inventory;
	}
	
	
	//Methods ---------------------------------------------------------
		
	public boolean initializeStock() {
		//create string array to store each line from file
		ArrayList<String> unformattedData = new ArrayList<>();
		
		try { //open file, read each line and add it to the string array
			File data = new File(inventoryFilePath);
			Scanner dataScanner = new Scanner(data); 
			while (dataScanner.hasNextLine()) {
				String line = dataScanner.nextLine();
				unformattedData.add(line);
			}
			dataScanner.close(); //close scanner when finished
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return false;
		}
		
		//iterate through each line from the file
		for (String dataLine : unformattedData) {
			//create a string array that separates data based on ',' delimitor
			String[] brokenData = dataLine.split(",");
			
			/* The first element of each array tells us which type of 
			 * object to declare. The object is declared using the other
			 * casted elements of that same array, and finally each product
			 * object is added to Inventory, the MediaProduct Array list.*/
			if ("CD".equals(brokenData[0])) {
				CDRecordProduct cd = new CDRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(cd);
			} else if ("Vinyl".equals(brokenData[0])){
				VinylRecordProduct v = new VinylRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(v);
			} else if ("Tape".equals(brokenData[0])) {
				TapeRecordProduct t = new TapeRecordProduct(brokenData[1],
						Double.parseDouble(brokenData[2]), 
						Integer.parseInt(brokenData[3]),
						Genre.valueOf(brokenData[4]));
				Inventory.add(t);
			}
		}
		
		return true; //return true for success !
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		for (MediaProduct item: Inventory) {
			if (item.equals(product)) {
				item.setPrice(newPrice);
				return true;
			}
		}
		return false;
	}
	
	public boolean addItem(MediaProduct product) {
		for (MediaProduct item: Inventory) {
        		if (item.equals(product)) {
				System.out.println("Item already exists: " + product.getTitle() + "Check Inventory again!");
            			return false; // if false, item exists
        		}
    		}
    		Inventory.add(product);
		return false;
	}
	
	public boolean removeItem(MediaProduct product) {
		return Inventory.remove(product);
	}
	
	public boolean saveStock() {
		try {
			// open the file with a FileWriter object
			FileWriter dataWriter = new FileWriter(inventoryFilePath);
			
			//iterate through each Inventory product
			for (MediaProduct unsavedProduct : Inventory) {
				String productType; //save this string depending on object type
				if (unsavedProduct instanceof CDRecordProduct) {
					productType = "CD";
				}
				else if (unsavedProduct instanceof VinylRecordProduct) {
					productType = "Vinyl";
				}
				else {
					productType = "Tape";
				}
				
				// get all attributes of the object 
				String title = unsavedProduct.title;
				double price = unsavedProduct.price;
				int year = unsavedProduct.year;
				Genre genre = unsavedProduct.genre;
				
				//create a string in the correct format and write it to the file
				String line = productType + "," + title + "," + price + "," + year + "," + genre + "\n";
				dataWriter.write(line);
			}
			dataWriter.close(); //close file when finished
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace(); 
			return false;
		}
		
		return true; //return true for success !!
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		
		// Creating a new ArrayList to hold media products
		ArrayList<MediaProduct> productsBelowPrice = new ArrayList<>();
		
		// Iterating through the ArrayList. If a product's price is below the indicated price, add it to the ArrayList.
		for (MediaProduct currentProduct : Inventory) {
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
		for (MediaProduct product : productList) {
			if (product instanceof VinylRecordProduct) {
				VinylRecordProduct vinylRecord = (VinylRecordProduct) product;
				vinylRecords.add(vinylRecord);
			}
		}
		return vinylRecords;
	}
		
	/**
	 * Creates a new ArrayList of CDRecordProduct product list that filters the CD records in media product list
	 * @param productList
	 * @return ArrayList of only the CDRecordProduct in it. 
	 */
	public ArrayList<CDRecordProduct> getCDRecordProduct(ArrayList<MediaProduct> productList) {
		ArrayList<CDRecordProduct> CDRecords = new ArrayList<CDRecordProduct>();
		for (MediaProduct product : productList) {
			if (product instanceof CDRecordProduct) {
				CDRecordProduct cdRecord = (CDRecordProduct) product;
				CDRecords.add(cdRecord);
			}
		}
		return CDRecords;
	}	
	
	/**
	 * Creates a new ArrayList of TapeRecordProduct product list that filters the tape records in media product list
	 * @param productList
	 * @return ArrayList of only the TapeRecordProduct in it. 
	 */
	public ArrayList<TapeRecordProduct> getTapeRecordProduct(ArrayList<MediaProduct> productList) { 
		ArrayList<TapeRecordProduct> tapeRecords = new ArrayList<TapeRecordProduct>();
		for (MediaProduct product : productList) {
			if (product instanceof TapeRecordProduct) {
				TapeRecordProduct tapeRecord = (TapeRecordProduct) product;
				tapeRecords.add(tapeRecord);
			}
		}
		return tapeRecords;

	
	}
}	
	

