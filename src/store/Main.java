package store;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] productElectronics = {
                new Product("Computer", 4000, 8.2),
                new Product("Headphones", 800, 9.0),
                new Product("Power bank", 200, 4.2),
                new Product("Charger", 360, 0.0),
        };
//        Product[] productBooks = {
//                new Product("History", 320, 9.0),
//                new Product("Biology", 120, 4.0),
//                new Product("Economics", 200, 8.3),
//        };
//        Category electronics = new Category("Electronics", productElectronics);
//        Category books = new Category("Electronics", productBooks);
//
//        Basket basket = new Basket(productElectronics);
//        Basket basketBooks = new Basket(productBooks);
        Scanner reader = new Scanner(System.in);
        User user = new User ("Sten","Li");
        System.out.println("Введите логин:");
        String login = reader.nextLine();
        System.out.println("Введите пароль:");
        String password = reader.nextLine();
        user.authentication(login,password);


    }
}
