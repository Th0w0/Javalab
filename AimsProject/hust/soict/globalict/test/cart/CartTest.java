package test.cart;
import aims.cart.*;
import aims.media.DigitalVideoDisc;

public class CartTest {

    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87,19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George", 87,24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        cart.searchByTitle("The lion King");
    }
}