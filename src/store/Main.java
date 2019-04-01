package store;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String login = null, password = null;
        Product[] productElectronics = {
                new Product("Computer", 4000, 8.2),
                new Product("Headphones", 800, 9.0),
                new Product("Power bank", 200, 4.2),
                new Product("Charger", 360, 0.0),
        };
        Product[] productBooks = {
                new Product("History", 320, 9.0),
                new Product("Biology", 120, 4.0),
                new Product("Economics", 200, 8.3),
        };
        Category electronics = new Category("Electronics", productElectronics);
        Category books = new Category("Electronics", productBooks);

        Basket basket = new Basket(productElectronics);
        Basket basketBooks = new Basket(productBooks);


        Scanner reader = new Scanner(System.in);
        User user = new User("Sten", "Li");
        System.out.println("Enter login:");
        if (reader.hasNextLine()) {
            login = reader.nextLine();
        }
        System.out.println("Enter password:");
        if (reader.hasNext()) {
            password = reader.nextLine();
        }
        user.authentication(login, password);

        int choise = 0;
        while(true){
            System.out.println("Select an action:");
            System.out.println("1) view the list of product catalogs;");
            System.out.println("2) View the list of products of a specific catalog;");
            System.out.println("3) Selection of goods in the basket;");
            System.out.println("4) The purchase of goods in the basket;");
            System.out.println("5) Disable switch.");
            boolean b = true;
            while (b)
            switch (choise){
                case 1: {

                }
            }

        }


    }

}
