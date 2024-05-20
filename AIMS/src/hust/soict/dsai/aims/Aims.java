package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc; // Assuming you have a class for DVDs
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleStoreMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    handleCartMenu();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void handleStoreMenu() {
        boolean back = false;
        while (!back) {
            store.print();
            storeMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.findMedia(title);
        if (media != null) {
            System.out.println(media);
            if (media instanceof DigitalVideoDisc) {
                mediaDetailsMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                        break;
                    case 2:
                        ((DigitalVideoDisc) media).play();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.findMedia(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.findMedia(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else {
                System.out.println("Cannot play this type of media.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStoreMenu() {
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Enter title, category, cost, director, and length separated by commas:");
                String input = scanner.nextLine().trim();
                String[] addDetails = input.split(",");
                // Trim each element to remove leading and trailing spaces
                for (int i = 0; i < addDetails.length; i++) {
                    addDetails[i] = addDetails[i].trim();
                }
                Media newMedia = new DigitalVideoDisc(addDetails[0], addDetails[1], Float.parseFloat(addDetails[2]), addDetails[3], Integer.parseInt(addDetails[4]));
                store.addMedia(newMedia);
                break;
            case 2:
                System.out.println("Enter the title of the media to remove:");
                String title = scanner.nextLine();
                Media media = store.findMedia(title);
                if (media != null) {
                    store.removeMedia(media);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    public static void handleCartMenu() {
        boolean back = false;
        while (!back) {
            cart.print();
            cartMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Implement filter medias in cart
                    break;
                case 2:
                    // Implement sort medias in cart
                    break;
                case 3:
                    System.out.println("Enter the title of the media to remove:");
                    String title = scanner.nextLine();
                    Media mediaToRemove = cart.findMedia(title);
                    cart.removeMedia(mediaToRemove);
                    break;
                case 4:
                    System.out.println("Enter the title of the media to play:");
                    String playTitle = scanner.nextLine();
                    Media media = cart.findMedia(playTitle);
                    if (media != null) {
                        if (media instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) media).play();
                        } else {
                            System.out.println("Cannot play this type of media.");
                        }
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
