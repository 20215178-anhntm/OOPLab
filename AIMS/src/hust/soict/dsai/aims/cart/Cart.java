package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();



//    public void addDigitalVideoDisc(DigitalVideoDisc disc){
//        if (qtyOrdered < MAX_NUMBERS_ORDERED)
//        {
//            itemOrdered[qtyOrdered] = disc;
//            qtyOrdered ++;
//            System.out.println("This disc has been added");
//        } else System.out.println("The cart is almost full");
//
//    }
//
////    public void addDigitalVideoDisc(hust.soict.dsai.aims.media.DigitalVideoDisc[] dvdList)
////    {
////        for (hust.soict.dsai.aims.media.DigitalVideoDisc disc : dvdList)
////            {
////                this.addDigitalVideoDisc(disc);
////            }
////    }
//
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList)
//    {
//        for (DigitalVideoDisc disc : dvdList)
//        {
//            this.addDigitalVideoDisc(disc);
//        }
//    }
//
//    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
//    {
//        addDigitalVideoDisc(dvd1,dvd2);
//    }
//
//    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
//        boolean found = false;
//        if (qtyOrdered>0)
//        {
//            for (int i = 0; i<qtyOrdered; i++){
//                if (itemOrdered[i].equals(disc)){
//                    for (int j = i; j<qtyOrdered-1; j++)
//                    {
//                        itemOrdered[j] = itemOrdered[j+1];
//                    }
//                    itemOrdered[qtyOrdered-1] = null;
//                    qtyOrdered--;
//                    System.out.println("The disc has been removed successfully");
//                    found = true;
//                }
//            }
//            if (!found) System.out.println("Do not have this products in the cart");
//
//        }
//        else {
//            System.out.println("Do not have any products in cart");
//        }
//    }

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

//    public void searchByID(int id){
//        boolean found = false;
//        for (int i = 0; i<qtyOrdered; i++){
//            if (itemOrdered[i].getId() == id){
//                found = true;
//                System.out.println("Item: " + itemOrdered[i].toString());
//                break;
//            }
//        }
//        if (found == false) System.out.println("Do not found anything");
//    }
//
//    public void searchByTitle(String title){
//        boolean found = false;
//        for (int i = 0; i<qtyOrdered; i++){
//            if (itemOrdered[i].isMatch(title)){
//                found = true;
//                System.out.println("Item: " + itemOrdered[i].toString());
//                break;
//            }
//        }
//        if (found == false) System.out.println("Do not found anything");
//    }


}
