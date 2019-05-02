package onllineStoreCollections;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Basket {
    private LinkedList<Product> purchasedGoods;

    public Basket() {
    }

    public Basket(LinkedList<Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }


    public LinkedList<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(LinkedList<Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public void showPurchasedGoods(LocalDate purchaseDate) {
        Formatter f = new Formatter();
        f.format("Date: %1s.%s.%3s", purchaseDate.getDayOfMonth(), purchaseDate.getMonthValue(), purchaseDate.getYear());
        System.out.println(f);
        for (Product p : purchasedGoods) {
            p.showProduct();
            System.out.println();
        }
    }

    public void showPurchasedGoods(LocalDate purchaseDate, Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.printf("Date: %26s.%s.%s \n \n", purchaseDate.getDayOfMonth(), purchaseDate.getMonthValue(), purchaseDate.getYear());
        System.out.printf("%s     %10s    %12s \n", "Products", "Category", "Price");
        drawLine();
        for (Product p : purchasedGoods) {
            int i =  p.getNameCategory().length() + 10 - p.getName().length();
            String s = nf.format(p.getPrise());
            System.out.printf("%s     %" + i + "s    %" + (20 - p.getNameCategory().length()) + "s \n", p.getName(), p.getNameCategory(), s);
        }
        drawLine();
    }

    private void drawLine() {
        for (int i = 0; i < 19; i++) {
            System.out.print("_ ");
        }
        System.out.println("_");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(purchasedGoods, basket.purchasedGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasedGoods);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "purchasedGoods=" + purchasedGoods +
                '}';
    }
}
