package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {

    public static final int MAX_NUMBERED_ITEMS = 50;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERED_ITEMS] ;
    private int itemCount;


    public void addDVD(DigitalVideoDisc dvd){
        if (itemCount < MAX_NUMBERED_ITEMS){
            itemsInStore[itemCount] = dvd;
            itemCount++;
            System.out.println("DVD is added to store!");
        }
        else System.out.println("There is not enough slot for item");
    }

    public void removeDVD(DigitalVideoDisc dvd){
        boolean found = false;
        if (itemCount>0)
        {
            for (int i = 0; i<itemCount; i++){
                if (itemsInStore[i].equals(dvd))
                {
                    for (int j = i; j<itemCount-1; j++)
                    {
                        itemsInStore[j] = itemsInStore[j+1];
                    }
                    itemsInStore[itemCount-1] = null;
                    itemCount--;
                    System.out.println("The disc has been removed");
                    found = true;
                }
            }
            if (found == false) System.out.println("Cannot find this item");
        }
        else System.out.println("Do not have any product in the store");
    }

    public void print() {
        System.out.println("Items in the store:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
    }
}
