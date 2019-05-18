package onlineStoreWithDatabase;


import java.io.*;
import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

import static onlineStoreWithDatabase.ConnectionData.*;

public class Main {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate purchaseDate = LocalDate.now();
        String login = null, password = null;
        Basket basket = new Basket();
        List<Product> basketProduct = new LinkedList<>();

        List<Product> productElectronics = fillTheList("productelectronics");

        List<Product> productBooks = fillTheList("productbooks");

        List<Category> productCategory = new LinkedList<>();

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
                    basket.writePurchasedGoods(purchaseDate, Locale.getDefault());
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

    public static List<Product> rewriteBasketCategories(List<Product> basketProduct, Category productCategory) {
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

    public static List<Category> sortedByPrice(List<Category> productCategory) {
        int numberOfElement = 0;
        System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        Category category = productCategory.get(numberOfElement - 1);
        List<Product> list = category.getProduct();
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
        productCategory.set(numberOfElement - 1, category);
        return productCategory;
    }

    public static List<Category> sortedByRating(List<Category> productCategory) {
        int numberOfElement = 0;
        System.out.println("Choose the catalog: \n 1) Electronics \n 2) Books");
        if (reader.hasNextInt()) {
            numberOfElement = reader.nextInt();
        }
        Category category = productCategory.get(numberOfElement - 1);
        List<Product> list = category.getProduct();
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
        productCategory.set(numberOfElement - 1, category);
        return productCategory;
    }

    public static List<Product> fillTheList(String s) {
        List<Product> list = new LinkedList<>();

        String QUERY = "SELECT * FROM ";
        QUERY = QUERY + s;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("product_name"));
                product.setPrise(resultSet.getDouble("price"));
                product.setRating(resultSet.getDouble("rating"));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return list;
    }
}
