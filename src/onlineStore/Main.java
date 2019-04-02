package onlineStore;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login = null, password = null;
        Basket basket = new Basket();
        Product[] basketProduct1 = new Product[0];
        Product[] basketProduct = new Product[0];
        int numberOfElement = 0;
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


        Scanner reader = new Scanner(System.in);
        User user = new User("Sten", "Li");
        System.out.println("Enter login(Sten):");
        if (reader.hasNextLine()) {
            login = reader.nextLine();
        }
        System.out.println("Enter password(Li):");
        if (reader.hasNext()) {
            password = reader.nextLine();
        }
        user.authentication(login, password);

        int choise = 0;
        boolean b = true;
        while (b) {
            System.out.println("\nSelect an action:");
            System.out.println("1) view the list of product catalogs;");
            System.out.println("2) View the list of products of a specific catalog;");
            System.out.println("3) Selection of goods in the basket;");
            System.out.println("4) The purchase of goods in the basket;");
            System.out.println("5) Disable application.");
            if (reader.hasNextInt()) {
                choise = reader.nextInt();
            }
//            while (b) {

            switch (choise) {
                case 1: {
                    electronics.showCatalog();
                    System.out.println();
                    books.showCatalog();
                    break;
                }
                case 2: {
                    System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
                    choise = reader.nextInt();
                    switch (choise) {
                        case 1: {
                            electronics.showCatalog();
                            break;
                        }
                        case 2: {
                            books.showCatalog();
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Choose the catalog for purchase: \n 1) Electronics \n 2) Books");
                    choise = reader.nextInt();
                    switch (choise) {
                        case 1: {
                            electronics.showCatalog();
                            System.out.println("Choose the product:");
                            if (reader.hasNextInt()) {
                                numberOfElement = reader.nextInt();
                            }
                            basketProduct1 = Arrays.copyOf(basketProduct, basketProduct.length + 1);
                            basketProduct1[basketProduct.length] = electronics.getSpecificArrayElement(numberOfElement - 1);
                            basketProduct = Arrays.copyOf(basketProduct1, basketProduct1.length);
                            break;
                        }
                        case 2: {
                            books.showCatalog();
                            System.out.println("Choose the product:");
                            if (reader.hasNextInt()) {
                                numberOfElement = reader.nextInt();
                            }
                            basketProduct1 = Arrays.copyOf(basketProduct, basketProduct.length + 1);
                            basketProduct1[basketProduct.length] = books.getSpecificArrayElement(numberOfElement - 1);
                            basketProduct = Arrays.copyOf(basketProduct1, basketProduct1.length);
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Purchased products: ");
                    basket.setPurchasedGoods(basketProduct1);
                    user.setUserBasket(basket);
                    basket = user.getUserBasket();
                    basket.showPurchasedGoods();
                    break;
                }
                case 5: {
                    b = !b;
                    break;
                }
            }

        }


    }

}
//}
