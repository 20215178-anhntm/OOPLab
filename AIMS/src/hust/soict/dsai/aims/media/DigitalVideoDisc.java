package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;


    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String director, int length, String director1, int length1) {
        super(director, length);
        this.director = director1;
        this.length = length1;
    }

    //    public DigitalVideoDisc(String title) {
//        this.title = title;
//        nbDigitalVideoDiscs++;
//        this.id = nbDigitalVideoDiscs;
//    }
//
//    public DigitalVideoDisc(String title, String category, float cost) {
//        this.title = title;
//        this.category = category;
//        this.cost = cost;
//        nbDigitalVideoDiscs++;
//        this.id = nbDigitalVideoDiscs;
//    }
//
//    public DigitalVideoDisc(String title, String category, String director, float cost) {
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.cost = cost;
//        nbDigitalVideoDiscs++;
//        this.id = nbDigitalVideoDiscs;
//    }
//
//    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.length = length;
//        this.cost = cost;
//        nbDigitalVideoDiscs++;
//        this.id = nbDigitalVideoDiscs;
//    }

//    public boolean isMatch(String title) {
//        return this.title.equalsIgnoreCase(title);
//    }

    public String toString(){
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }



}
