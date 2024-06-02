package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media implements Playable {

	private String director;
	private int length;
	
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String director, int length) {
		super(title);
		this.director = director;
		this.length = length;
	}
	
	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void showDetails() {
		System.out.println("ID: " + getId());
		System.out.println("Title: " + getTitle());
		System.out.println("Director: " + director);
		System.out.println("Category: " + getCategory());
		System.out.println("Length: " + length);
		System.out.println("Cost: $" + getCost());
	}
	
	@Override
	public void play() throws PlayerException {}
	
}
