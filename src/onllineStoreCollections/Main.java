package onllineStoreCollections;

import java.time.LocalDate;
import java.util.*;

public class Main {
    static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate purchaseDate = LocalDate.now();
        String login = null, password = null;
        Basket basket = new Basket();
        LinkedList<Product> basketProduct = new LinkedList<>();

        LinkedList<Product> productElectronics = new LinkedList<>();
        productElectronics.add(new Product("Computer", 4000, 8.2));
        productElectronics.add(new Product("AAA", 4000, 8.2));
        productElectronics.add(new Product("Headphones", 800, 9.0));
        productElectronics.add(new Product("Power bank", 200, 4.2));
        productElectronics.add(new Product("Charger", 360, 0.0));

        LinkedList<Product> productBooks = new LinkedList<>();
        productBooks.add(new Product("History", 320, 9.0));
        productBooks.add(new Product("Biology", 120, 4.0));
        productBooks.add(new Product("Economics", 200, 8.3));

        LinkedList<Category> productCategory = new LinkedList<>();

        productCategory.add(new Category("Electronics", productElectronics));
        productCategory.add(new Category("Books", productBooks));

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

        int choice = 0;
        boolean b = true;
        while (b) {
            System.out.println("\nSelect an action:");
            System.out.println("1) View the list of product catalogs;");
            System.out.println("2) View the list of products of a specific catalog;");
            System.out.println("3) Selection of goods in the basket;");
            System.out.println("4) The purchase of goods in the basket;");
            System.out.println("5) View the catalog sorted by price;");
            System.out.println("6) View the catalog sorted by rating;");
            System.out.println("7) Disable application.");
            if (reader.hasNextInt()) {
                choice = reader.nextInt();
            }

            switch (choice) {
                case 1: {
                    for (Category category : productCategory) {
                        category.showCatalog();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
                    choice = reader.nextInt();
                    productCategory.get(choice - 1).showCatalog();
                    break;
                }
                case 3: {
                    System.out.println("Choose the catalog for purchase: ");
                    for (int i = 0; i < productCategory.size(); i++) {
                        System.out.println(i + 1 + ") " + productCategory.get(i).getName());
                    }
                    choice = reader.nextInt();
                    basketProduct = rewriteBasketCategories(basketProduct, productCategory.get(choice - 1));
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
                    productCategory = sortedByPrice(productCategory);
                    break;
                }
                case 6: {
                    productCategory = sortedByRating(productCategory);
                    break;
                }
                case 7: {
                    b = !b;
                    break;
                }
            }
        }
    }

    public static LinkedList<Product> rewriteBasketCategories(LinkedList<Product> basketProduct, Category productCategory) {
        productCategory.showCatalog();
        int numberOfElement = 0;
        System.out.println("Choose the product:");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        Product p = productCategory.getSpecificArrayElement(numberOfElement - 1);
        p.setNameCategory(productCategory.getName());
        basketProduct.add(p);
        return basketProduct;
    }

    public static LinkedList<Category>  sortedByPrice (LinkedList<Category> productCategory) {
        int numberOfElement = 0;
        System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        Category category = productCategory.get(numberOfElement-1);
        LinkedList<Product> list = category.getProduct();
        Product[] productArray = list.toArray(new Product[list.size()]);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < productArray.length - 1; i++) {
                Product productRewrite;
                if (productArray[i].getPrise() > productArray[i + 1].getPrise()) {
                    isSorted = false;

                    productRewrite = productArray[i];
                    productArray[i] = productArray[i + 1];
                    productArray[i + 1] = productRewrite;
                }
            }
        }
        list = new LinkedList<Product>(Arrays.asList(productArray));
        category.setProduct(list);
        productCategory.set(numberOfElement-1, category);
        return productCategory;
    }

    public static LinkedList<Category>  sortedByRating (LinkedList<Category> productCategory) {
        int numberOfElement = 0;
        System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        Category category = productCategory.get(numberOfElement-1);
        LinkedList<Product> list = category.getProduct();
        Product[] productArray = list.toArray(new Product[list.size()]);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < productArray.length - 1; i++) {
                Product productRewrite;
                if (productArray[i].getRating() > productArray[i + 1].getRating()) {
                    isSorted = false;

                    productRewrite = productArray[i];
                    productArray[i] = productArray[i + 1];
                    productArray[i + 1] = productRewrite;
                }
            }
        }
        list = new LinkedList<Product>(Arrays.asList(productArray));
        category.setProduct(list);
        productCategory.set(numberOfElement-1, category);
        return productCategory;
    }
}
