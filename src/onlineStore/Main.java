package onlineStore;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate purchaseDate = LocalDate.now();
        String login = null, password = null;
        Basket basket = new Basket();
        Product[] basketProduct = new Product[0];
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
        Category[] productCategory = new Category[2];

        productCategory[0] = new Category("Electronics", productElectronics);
        productCategory[1] = new Category("Books", productBooks);

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

            switch (choise) {
                case 1: {
                    for (Category category : productCategory) {
                        category.showCatalog();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
                    choise = reader.nextInt();
                    productCategory[choise - 1].showCatalog();
                    break;
                }
                case 3: {
                    System.out.println("Choose the catalog for purchase: ");
                    for (int i = 0; i < productCategory.length; i++) {
                        System.out.println(i + 1 + ") " + productCategory[i].getName());
                    }
                    choise = reader.nextInt();
                    basketProduct = rewriteBasketCategories(basketProduct, productCategory[choise - 1]);
                    break;
                }
                case 4: {
                    basket.setPurchasedGoods(basketProduct);
                    user.setUserBasket(basket);
                    basket = user.getUserBasket();
                    basket.showPurchasedGoods(purchaseDate, Locale.getDefault());
                    break;
                }
                case 5: {
                    b = !b;
                    break;
                }
            }
        }
    }

    public static Product[] rewriteBasketCategories(Product[] basketProduct, Category productCategory) {
        productCategory.showCatalog();
        int numberOfElement = 0;
        System.out.println("Choose the product:");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        basketProduct = Arrays.copyOf(basketProduct, basketProduct.length + 1);
        basketProduct[basketProduct.length - 1] = productCategory.getSpecificArrayElement(numberOfElement - 1);
        basketProduct[basketProduct.length-1].setNameCategory(productCategory.getName());
        return basketProduct;
    }
}
