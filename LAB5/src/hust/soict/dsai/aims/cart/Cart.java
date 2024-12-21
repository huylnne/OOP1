package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.*;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Thêm Media vào giỏ hàng
    public void addMedia(Media item) {
        if (itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + " is already in the cart.");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " has been added to the cart.");
        }
    }

    // Xóa Media khỏi giỏ hàng
    public void removeMedia(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println(item.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(item.getTitle() + " is not in the cart.");
        }
    }

    // Tính tổng giá tiền
    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    // In giỏ hàng
    public void print() {
        System.out.println("*********************CART**************************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            int i = 1;
            for (Media item : itemsOrdered) {
                System.out.println(i + ". " + item.getTitle() + " - " + item.getCategory() + " - " + item.getCost() + " $");
                i++;
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        if (id > 0 && id <= itemsOrdered.size()) {
            Media item = itemsOrdered.get(id - 1);
            System.out.println("Result: " + item.getTitle() + " - " + item.getCategory() + " - " + item.getCost() + " $");
        } else {
            System.out.println("No item found with ID: " + id);
        }
    }

    // Tìm kiếm theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Result: " + item.getTitle() + " - " + item.getCategory() + " - " + item.getCost() + " $");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with title: " + title);
        }
    }

    // Tìm Media trong giỏ hàng
    public Media findMedia(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    // Làm trống giỏ hàng
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }

    // Sắp xếp theo tiêu đề và giá
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    // Sắp xếp theo giá và tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }
}
