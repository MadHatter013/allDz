package store;

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

}
