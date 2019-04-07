package onlineStore;

import java.util.Arrays;

public class Basket {
    private Product[] purchasedGoods;

    public Basket() {
    }

    public Basket(Product[] purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }


    public Product[] getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(Product[] purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public void showPurchasedGoods(){
        for (Product p: purchasedGoods) {
            p.showProduct();
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Arrays.equals(purchasedGoods, basket.purchasedGoods);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(purchasedGoods);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "purchasedGoods=" + Arrays.toString(purchasedGoods) +
                '}';
    }
}
