package book;
import service.*;
public class PaperBook extends Book implements Shippable{
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    public int getStock() { return stock; }
    public void reduceStock(int quantity) {
        if (stock < quantity) throw new IllegalArgumentException("Not enough stock.");
        stock -= quantity;
    }

//    @Override
//    public void deliver(String email, String address) {
//        System.out.println("Quantum book store: Sending paper book to " + address);
//    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public void ship(String address) {
        ShippingService.ship(address, title);
    }
}
