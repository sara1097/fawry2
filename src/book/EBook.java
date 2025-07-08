package book;
import service.*;
public class EBook extends Book implements Emailable{
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }

//    @Override
//    public void deliver(String email, String address) {
//        System.out.println("Quantum book store: Sending eBook to " + email);
//    }

    @Override
    public boolean isPurchasable() {
        return true;
    }
    @Override
    public void send(String email) {
        MailService.send(email, title);
    }

}
