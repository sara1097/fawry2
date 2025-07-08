package service;

public class ShippingService {
    public static void ship(String address, String title) {
        System.out.println("Quantum book store: ShippingService - shipped '" + title + "' to " + address);
    }
}
