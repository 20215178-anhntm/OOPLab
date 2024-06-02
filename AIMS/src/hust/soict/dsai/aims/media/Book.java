package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author is already added.");
			return;
		}
		else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " is added to book " + getTitle());
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName + " is removed.");
			return;
		}
		else System.out.println("Author is not available.");
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(" + getId() + ") ");
		sb.append("Book: ");
		sb.append(getTitle() + " by ");
		for (String author : authors) {
			sb.append(author);
			sb.append(", ");
		}
		sb.append(" - Category: ");
		sb.append(getCategory());
		sb.append(" - $" + getCost());
		return sb.toString();
	}
	
	public void showDetails() {
		StringBuilder sbAuthors = new StringBuilder();
		sbAuthors.append("Author(s): ");
		for(String author : authors) {
			sbAuthors.append(author);
			sbAuthors.append("    ");
		}
		System.out.println("ID: " + getId());
		System.out.println("Title: " + getTitle());
		System.out.println(sbAuthors.toString());
		System.out.println("Category: " + getCategory());
		System.out.println("Cost: $" + getCost());
	}
}
