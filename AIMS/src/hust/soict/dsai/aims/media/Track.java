package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	@Override
	public void play() throws PlayerException {
		if (length <= 0) {
			throw new PlayerException("ERROR: Track length is non-positive");
		} else {
			System.out.println("Playing track: " + title);
			System.out.println("Track length: " + length);
		}
	}
	
	public boolean equals(Object other) {
		if (other instanceof Track) {
			Track otherTrack = (Track) other;
			return (this.title.equals(otherTrack.getTitle()) 
					&& this.length == otherTrack.getLength());
		} else return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title);
		sb.append(" - ");
		sb.append(length);
		sb.append(" minutes");
		return sb.toString();
	}
}
