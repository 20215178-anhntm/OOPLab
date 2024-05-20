package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();


    public void addMedia(Media media){
        if(itemsOrdered.size()<MAX_NUMBERS_ORDERED){
            if (!itemsOrdered.contains(media)){
                itemsOrdered.add(media);
                System.out.println("This disc has been added");
            }
        } else System.out.println("The cart is almost full");
    }

    public void removeMedia(Media media){
        if (itemsOrdered.size()>0){
            if (itemsOrdered.contains(media)){
                itemsOrdered.remove(media);
                System.out.println("The disc has been removed successfully");
            } else System.out.println("Do not have this products in the cart");
        } else System.out.println("Do not have any product");
    }

    public float totalCost(){
        float sum = 0;
        for (Media media : itemsOrdered)
        {
            sum += media.getCost();
        }
        return sum;
    }

    public void print()
    {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 0;
        for (Media media : itemsOrdered){
            System.out.println((i+1) + "." + media.getTitle());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public Media findMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // Media not found
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public void placeOrder() {
        // Simulate placing an order by emptying the cart
        emptyCart();
        System.out.println("Order placed successfully. Your cart has been emptied.");
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                return m1.getTitle().compareTo(m2.getTitle());
            }
        });
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                return Float.compare(m2.getCost(), m1.getCost());
            }
        });
    }

    public List<Media> filterByCategory(String category) {
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getCategory().equals(category)) {
                filteredList.add(media);
            }
        }
        return filteredList;
    }

}
