package ict.aimsprojectweek5.cart;
import ict.aimsprojectweek5.media.Media;
import ict.aimsprojectweek5.media.DigitalVideoDisc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    //private ArrayList<Media> itemsOrdered = new ArrayList<>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Phương thức thêm media vào giỏ hàng
    public void addMedia(Media media){
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full. Please remove some items to continue.");
        }
        else{
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart");
            if(itemsOrdered.size() >= 18){
                System.out.println("The cart is almost full");
            }
        }
    }

    // Phương thức xóa media khỏi giỏ hàng
    public void removeMedia(Media media){
        if(itemsOrdered.remove(media)){
            System.out.println("The media has been removed from the cart");
        } else {
            System.out.println("The media is not found in cart.");
        }
    }

    // Phương thức tính tổng chi phí
    public double totalCost(){
        double total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    // Phương thức hiển thị danh sách các mặt hàng đã đặt hàng
    public void orderedItems(){
        if(itemsOrdered.isEmpty()){
            System.out.println("There are no items in the cart.");
        }
        else{
            System.out.println("***********************CART***********************");
            System.out.println("Ordered Items:");
            for(int i = 0; i < itemsOrdered.size(); i++){
                itemsOrdered.get(i).toString(i + 1);
            }
            System.out.println("**************************************************");
            System.out.println("Total Cost is: " + totalCost() + "$");
        }
    }


    // Phương thức đếm số lượng đĩa DVD trong giỏ hàng
    public int numberDVD(){
        int cnt = 0 ;
        for(Media item : itemsOrdered){
            if(item instanceof DigitalVideoDisc) {
                cnt++;
            }
        }
        return cnt;
    }

    // Phương thức lọc các phần tử trong giỏ hàng dựa trên tiêu đề
    public void filterByTitle(String title) {
        ArrayList<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("No items found with title \"" + title + "\" in the cart.");
        } else {
            System.out.println("Items with title \"" + title + "\":");
            for (Media media : filteredList) {
                media.toString(itemsOrdered.indexOf(media) + 1);
            }
        }
    }

    // Phương thức sắp xếp các phần tử trong giỏ hàng theo tiêu đề
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        System.out.println("Items sorted by title:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            itemsOrdered.get(i).toString(i + 1);
        }
    }

    // Phương thức sắp xếp các phần tử trong giỏ hàng theo giá
    public void sortByCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost));
        System.out.println("Items sorted by cost:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            itemsOrdered.get(i).toString(i + 1);
        }
    }



    // Phương thức đặt hàng
    public void placeOrder() {
        System.out.println("An order has been created.");
        itemsOrdered.clear(); // Xóa giỏ hàng sau khi đặt hàng
    }
    public Media searchMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public ObservableList<Media> searchByID(Integer id) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
//                media.toString();
                result.add(media);
            }
        }
        return result;
    }

    public ObservableList<Media> searchByTitle(String title) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getTitle().contains(title)) {
                result.add(media);
            }
        }
        return result;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public static void main(String[] args) {
        System.out.print("cart");
    }

    public void clear() {
        itemsOrdered.clear();
    }

}