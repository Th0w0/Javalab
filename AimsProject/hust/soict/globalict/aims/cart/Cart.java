package aims.cart;

import  aims.media.*;
import java.util.ArrayList;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    
  
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media newMedia){
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full. Please remove some items to continue.");
        }
        else{
            itemsOrdered.add(newMedia);
            System.out.println("The media has been added to the cart");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.remove(media)){
            System.out.println("The media has been removed from the cart");
        } else {
            System.out.println("The media is not found in cart.");
        }
    }


   
 }
     
         