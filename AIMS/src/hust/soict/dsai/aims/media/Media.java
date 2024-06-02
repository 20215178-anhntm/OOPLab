package hust.soict.dsai.aims.media;

import java.util.Comparator;
import hust.soict.dsai.aims.comparator.*;

public abstract class Media {

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	private static int mediaId = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(String title) {
		this(title, "", 0.0f);
	}
	
	public Media(String title, String category) {
		this(title, category, 0.0f);
	}
	
	public Media(String title, String category, float cost) {
		mediaId++;
		this.id = mediaId;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object other) {
		try {
			Media otherMedia = (Media) other;
			return this.title.equals(otherMedia.getTitle());
		} catch (NullPointerException e) {
			System.err.println("ERROR: Invalid object for comparison");
		} catch (ClassCastException e) {
			return false; // Cannot cast other object to Media -> not an instance of Media -> not equal
		}
		return false;
	}
	
	public abstract void showDetails();

	public boolean match(String title, int id) {
		return (title.equals(this.title)) && (id == this.id);
	}
}
