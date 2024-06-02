package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class Cart {
	
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public Cart() {}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " is added to cart");
		}
		else {
			throw new LimitExceededException("ERROR: The number of media" 
					+ "has reached its limit");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " is removed from cart");
		} else {
			System.out.println("Item not found in cart");
		}
	}
	
	public boolean isAvailable(String title, int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public Media findMedia(String title, int id) {
		Media result = new Disc("");
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				result = media;
				break;
			}
		}
		return result;
	}
	
	public void filterMedia(int id) {
		System.out.println("Found media(s):");
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				media.showDetails();
				return;
			}
		}
	}
	
	public void filterMedia(String[] keywords) {
		System.out.println("Found media(s):");
		for (Media media : itemsOrdered) {
			for (String keyword : keywords) {
				if (media.getTitle().contains(keyword)) {
					System.out.println(media.toString());
					break;
				}
			}
		}
	}
	
	public float totalCost() {
		float cost = 0;
		for (Media media : itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public void viewCart() {
		System.out.println("Items placed in cart:");
		System.out.println("----------------------------");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
	}
	
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void clear() {
		itemsOrdered.clear();
	}
	
}
