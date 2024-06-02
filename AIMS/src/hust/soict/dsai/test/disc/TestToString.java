package hust.soict.dsai.test.disc;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class TestToString {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();

		CompactDisc cd1 = new CompactDisc("cd1", "cat1", 13.1f, "dir1", "artist1");
		Track track1 = new Track("track1", 10);
		Track track2 = new Track("track2", 20);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "cat2", 55, "dir2", 100);
		
		Book book1 = new Book("book1", "cat3", 300);
		book1.addAuthor("author1");
		book1.addAuthor("author2");
		
		mediae.add(cd1);
		mediae.add(book1);
		mediae.add(dvd1);
		
		for(Media media : mediae) {
			System.out.println(media.toString());
		}
	}

}
