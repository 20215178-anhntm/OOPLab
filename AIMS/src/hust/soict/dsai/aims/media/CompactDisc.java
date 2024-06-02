package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String artist, String director) {
		this(title, artist);
		setDirector(director);
	}

	public CompactDisc(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director, 0);
		this.artist = artist;
	}
	
	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("This track is already added.");
			return;
		}
		else {
			tracks.add(newTrack);
			setLength(getLength() + newTrack.getLength());
			System.out.println("Track " + newTrack.getTitle() + " is added to CD " + getTitle());
		}
	}
	
	public void addTrack(Track... tracks) {
		for (Track track : tracks) {
			addTrack(track);
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			setLength(getLength() - track.getLength());
			System.out.println("Track " + track.getTitle() + " is removed.");
			return;
		}
		else System.out.println("Track is not available.");
	}
	
	@Override
	public void play() throws PlayerException {
		if (getLength() > 0) {
			System.out.println("Playing CD: " + getTitle());
			System.out.println("CD length: " + getLength());
			for (Track track : tracks) {
				try {
					track.play();
				} catch (Exception e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(" + getId() + ") ");
		sb.append("CD: ");
		sb.append(getTitle());
		sb.append(" by " + artist + " - ");
		sb.append("Director: " + getDirector());
		sb.append(" - Category: ");
		sb.append(getCategory());
		sb.append(" - $" + getCost());
		return sb.toString();
	}
	
	public void showDetails() {
		StringBuilder sbTracks = new StringBuilder();
		sbTracks.append("Tracks: ");
		for(Track track : tracks) {
			sbTracks.append("\n\t");
			sbTracks.append(track.toString());
		}
		System.out.println("ID: " + getId());
		System.out.println("Title: " + getTitle());
		System.out.println("Director: " + getDirector());
		System.out.println("Category: " + getCategory());
		System.out.println(sbTracks.toString());
		System.out.println("Length: " + getLength());
		System.out.println("Cost: $" + getCost());
	}
	
}
