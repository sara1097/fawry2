package service;

public class MailService {
    public static void send(String email, String title) {
        System.out.println("Quantum book store: MailService - sent '" + title + "' to " + email);
    }
}
