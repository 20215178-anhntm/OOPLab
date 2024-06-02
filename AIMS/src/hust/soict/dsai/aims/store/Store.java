package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Store {

	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public Store() { }
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("Item is already in store");
			return;
		} else {
			itemsInStore.add(media);
			System.out.println(media.getTitle() + " is added to store");
		}
	}
	
	public void addMedia(Media... medias) {
		for (Media media : medias) {
			addMedia(media);
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println(media.getTitle() + " is removed from store");
		} else {
			System.out.println("Item not found in store");
		}
	}
	
	public void viewStore() {
		System.out.println("Items available in store:");
		System.out.println("----------------------------");
		for(Media media : itemsInStore) {
			System.out.println(media.toString());
		}
	}
	
	public boolean isAvailable(String title, int id) {
		boolean found = false;
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public Media findMedia(String title, int id) {
		Media result = new Disc("");
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				result = media;
				break;
			}
		}
		return result;
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}