package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String director, int length) {
        super(director, length);
    }

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String director, int length, String artist, List<Track> tracks) {
        super(director, length);
        this.artist = artist;
        this.tracks = tracks;
    }
    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println("This track has been added successfully");
        } else System.out.println("This track is existed");
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("This track has been removed successfully");
        } else System.out.println("This track is not existed");
    }
    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks){
            totalLength = track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CompactDisc [title=" + getTitle() + ", category=" + getCategory() + ", cost=" + getCost() + ", artist=" + artist + "]";
    }
}
