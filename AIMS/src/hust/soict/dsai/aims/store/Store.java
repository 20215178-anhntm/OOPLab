package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {

    public static final int MAX_NUMBERED_ITEMS = 50;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    //private int itemCount;

    public void addMedia(Media media){
        if(itemsInStore.size()<MAX_NUMBERED_ITEMS){
            if (!itemsInStore.contains(media)){
                itemsInStore.add(media);
                System.out.println("This media has been added");
            }
        } else System.out.println("The store is almost full");
    }

    public void removeMedia(Media media){
        if (itemsInStore.size()>0){
            if (itemsInStore.contains(media)){
                itemsInStore.remove(media);
                System.out.println("The media has been removed successfully");
            } else System.out.println("Do not have this products in the cart");
        } else System.out.println("Do not have any products in the store");

    }


//    public void addDVD(DigitalVideoDisc dvd){
//        if (itemCount < MAX_NUMBERED_ITEMS){
//            itemsInStore[itemCount] = dvd;
//            itemCount++;
//            System.out.println("DVD is added to store!");
//        }
//        else System.out.println("There is not enough slot for item");
//    }
//
//    public void removeDVD(DigitalVideoDisc dvd){
//        boolean found = false;
//        if (itemCount>0)
//        {
//            for (int i = 0; i<itemCount; i++){
//                if (itemsInStore[i].equals(dvd))
//                {
//                    for (int j = i; j<itemCount-1; j++)
//                    {
//                        itemsInStore[j] = itemsInStore[j+1];
//                    }
//                    itemsInStore[itemCount-1] = null;
//                    itemCount--;
//                    System.out.println("The disc has been removed");
//                    found = true;
//                }
//            }
//            if (found == false) System.out.println("Cannot find this item");
//        }
//        else System.out.println("Do not have any product in the store");
//    }

    public void print() {
        System.out.println("Items in the store:");
        int i = 0;
        for (Media media : itemsInStore) {
            System.out.println((i + 1) + ". " + media.getTitle());
        }
    }
}
