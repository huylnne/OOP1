package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Mai Mai 1 tinh yeu", "Nhac remix", 18.5f, "Dan Truong", 97);
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("happy", 3));
        tracks.add(new Track("i love u", 4));
        CompactDisc cd = new CompactDisc(2, "mot minh", "that tinh", 25.5f, "Khanh Duy", tracks);
        List<String> authors = new ArrayList<String>();
        authors.add(" Huy Le");
        authors.add("Le Hieu");
        Book book = new Book(3, "chuyen tinh anh va em", "tuoitre", 25.2f, authors);
        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, store, cart);
    }

    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println("AIMS:\n" +
                    "--------------------------------\n" +
                    "1. View store\n" +
                    "2. Update store\n" +
                    "3. See current cart\n" +
                    "0. Exit\n" +
                    "--------------------------------\n" +
                    "Please choose a number: 0-1-2-3");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    storeMenu(scanner, store, cart);
                    break;
                case 2:
                    updateStoreMenu(scanner, store);
                    break;
                case 3:
                    cart.print();
                    cartMenu(scanner, cart);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    public static void cartMenu(Scanner scanner, Cart cart) {
        while (true) {
            System.out.println("Cart Menu:\n" +
                    "--------------------------\n" +
                    "1. See items in cart\n" +
                    "2. Remove media from cart\n" +
                    "3. Place order\n" +
                    "0. Back\n" +
                    "--------------------------");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1:
                    cart.print();
                    break;
                case 2:
                    System.out.print("Enter media title to remove: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item != null) {
                        cart.removeMedia(item);
                        System.out.println("Media removed from cart.");
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 3:
                    System.out.println("Your cart has been paid. Thanks for your purchase!");
                    cart.emptyCart();
                    break;
                case 0:
                    return; // Go back to the previous menu
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
     
    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Store Menu:\n" +
                "--------------------------\n" +
                "1. See media details\n" +
                "2. Add media to cart\n" +
                "3. Play media\n" +
                "0. Back\n" +
                "--------------------------");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (option) {
            case 1:
                System.out.print("Enter media title: ");
                String title = scanner.nextLine();
                Media media = store.findMedia(title);
                if (media != null) {
                    System.out.println(media.toString());
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 2:
                System.out.print("Enter media title to add to cart: ");
                String mediaTitle = scanner.nextLine();
                Media item = store.findMedia(mediaTitle);
                if (item != null) {
                    cart.addMedia(item);
                    System.out.println("Media added to cart.");
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 3:
                System.out.print("Enter media title to play: ");
                String playTitle = scanner.nextLine();
                Media playMedia = store.findMedia(playTitle);
                if (playMedia != null) {
                    if (playMedia instanceof Playable) {
                        ((Playable) playMedia).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 0:
                return; // Quay lại menu chính
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("==========================\n" +
                "1. Add Media\n" +
                "2. Delete Media\n" +
                "3. Update Media in Store\n" +
                "0. Back\n" +
                "==========================\n" +
                "Option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("1. DigitalVideoDisc\n" +
                        "2. CompactDisc\n" +
                        "3. Book\n" +
                        "-------\n" +
                        "-> Your type:");
                int option2 = scanner.nextInt();
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                switch (option2) {
                    case 1:
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter dvd's length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(id, title, category, cost, director, length));
                        break;
                    case 2:
                        System.out.print("Enter artist's name: ");
                        StringBuffer artist = new StringBuffer(scanner.nextLine());
                        System.out.print("Enter number of tracks: ");
                        int nbTrack = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<Track>();
                        for (int i = 0; i < nbTrack; i++) {
                            System.out.print("Enter Track[" + i + "]'s name: ");
                            String trackName = scanner.nextLine();
                            System.out.print("Enter Track[" + i + "]'s length: ");
                            int trackLength = scanner.nextInt();
                            scanner.nextLine();
                            tracks.add(new Track(trackName, trackLength));
                        }
                        store.addMedia(new CompactDisc(id, title, category, cost, artist.toString(), tracks));
                        break;
                    case 3:
                        ArrayList<String> authors = new ArrayList<>();
                        System.out.println("Enter author's names (type 'done' to finish): ");
                        while (true) {
                            String authorName = scanner.nextLine();
                            if (authorName.equalsIgnoreCase("done")) break;
                            authors.add(authorName);
                        }
                        store.addMedia(new Book(id, title, category, cost, authors));
                        break;
                    default:
                        System.out.println("Invalid type. Please try again.");
                        break;
                }
                break;
            case 2:
                System.out.print("Enter item's title: ");
                scanner.nextLine();
                String titleToDelete = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if (item.getTitle().equalsIgnoreCase(titleToDelete)) {
                        iter.remove();
                        System.out.println(item.getClass().getSimpleName() + " '" + item.getTitle() + "' has been deleted from the store.");
                    }
                }
                break;
            case 3:
                System.out.print("Enter item's id: ");
                int updateId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new category: ");
                String newCategory = scanner.nextLine();
                System.out.print("Enter new cost: ");
                float newCost = scanner.nextFloat();
                store.getItemsInStore().get(updateId).setTitle(newTitle);
                store.getItemsInStore().get(updateId).setCategory(newCategory);
                store.getItemsInStore().get(updateId).setCost(newCost);
                System.out.println("Item updated successfully.");
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}

        