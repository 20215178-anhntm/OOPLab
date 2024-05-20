package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class TestPolymorphism {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();

        Book book = new Book();
        book.setTitle("Effective Java");
        book.setCategory("Programming");
        book.setCost(45.0f);
        //book.setAuthor("Joshua Bloch");

        CompactDisc cd = new CompactDisc("Director", 10);
        cd.setTitle("Thriller");
        cd.setCategory("Music");
        cd.setCost(10.0f);
        //cd.setArtist("Michael Jackson");

        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Science Fiction", 15.0f, "Director1", 11);
        dvd.setTitle("Inception");
        dvd.setCategory("Science Fiction");
        dvd.setCost(15.0f);

        mediaList.add(book);
        mediaList.add(cd);
        mediaList.add(dvd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
