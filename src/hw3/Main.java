package hw3;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		StockManagerSingleton testManager = StockManagerSingleton.getInstance();
		
		boolean initialize;
		boolean save;
		initialize = testManager.initializeStock();
		save = testManager.saveStock();
		
		if (initialize == true && save == true) {
			System.out.println("Initialized and saved successfully"); 
			testManager.printListOfMediaProduct(testManager.getInventoryArray());
		}
		else {
			System.out.println("Something went wrong, check that file path or its data");
			System.exit(0); //Exit program upon failure to initialize or save inventory
		}
		
		MediaProduct demoProduct = new CDRecordProduct("Dangerous", 21.99, 1991, Genre.POP);
        	if (testManager.addItem(demoProduct)) {
            		System.out.println("Product added successfully.");
        	} else {
            		System.out.println("Product already exists.");
       		}

        	if (testManager.updateItemPrice(demoProduct, 15.99)) {
            		System.out.println("Price updated!");
        	} else {
            		System.out.println("Failed to update the price");
        	}

        	if (testManager.removeItem(demoProduct)) {
            		System.out.println("Removed successfully!");
        	} else {
            		System.out.println("Failed to remove!");
        	}

        	if (testManager.saveStock()) {
           		System.out.println("Saved!");
        	} else {
            		System.out.println("Failed to save!");
        	}
    
		
		// Media Below Price
		ArrayList <MediaProduct> mediaBelowTwenty = new ArrayList<>();
		mediaBelowTwenty = testManager.getMediaProductBelowPrice(20);
		
		System.out.println("\nCheap! Cheap! Under $20!\n");
		
		testManager.printListOfMediaProduct(mediaBelowTwenty);
		
		// Test functions for get all instances of a specific subclass from list of various subclasses
		System.out.println("Get all tape records from mediaBelowTwenty list.");
		ArrayList<TapeRecordProduct> tapeRecords = testManager.getTapeRecordProduct(mediaBelowTwenty);
		testManager.printListOfMediaProduct(tapeRecords);
		
		System.out.println("Get all CD records from mediaBelowTwenty list");
		ArrayList<CDRecordProduct> cdRecords = testManager.getCDRecordProduct(mediaBelowTwenty);
		testManager.printListOfMediaProduct(cdRecords);
		
		System.out.println("Get all vinyl records from mediaBelowTwenty list");
		ArrayList<VinylRecordProduct> vinylRecords = testManager.getVinylRecordProduct(mediaBelowTwenty);
		testManager.printListOfMediaProduct(vinylRecords);
	
		

	}

}
