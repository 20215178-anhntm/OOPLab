package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String director, int length) {
		super(title, director, length);
	}
	
	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(title, category, cost, director, length);
	}
	
	@Override
	public void play() throws PlayerException{
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive");
		} else {
			System.out.println("Playing DVD: " + getTitle());
			System.out.println("DVD length: " + getLength());
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(" + getId() + ") ");
		sb.append("DVD: ");
		sb.append(getTitle());
		sb.append(" - Director: ");
		sb.append(getDirector());
		sb.append(" - Category: ");
		sb.append(getCategory());
		sb.append(" - $" + getCost());
		return sb.toString();
	}
}
