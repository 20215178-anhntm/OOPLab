package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    // Constructor that accepts title, category, cost, director, and length
    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(director, length); // Call the superclass constructor
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
    }

    // Constructor that accepts title only
    public DigitalVideoDisc(String title) {
        super("", 0); // Call the superclass constructor with default values
        this.setTitle(title);
        nbDigitalVideoDiscs++;
    }

    // Constructor that accepts title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super("", 0); // Call the superclass constructor with default values
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc [title=" + getTitle() + ", category=" + getCategory() + ", cost=" + getCost() + ", length=" + getLength() + ", director=" + getDirector() + "]";
    }
}
