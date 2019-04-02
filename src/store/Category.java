package store;

import java.util.Arrays;

public class Category {
    private String name;
    private Product[] product;

    public Category(String name, Product[] product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public void showCatalog() {
        for (int i = 0; i < product.length; i++) {
            System.out.print(i+1 + ": ");
            product[i].showProduct();
        }
    }

    public Product getSpecificArrayElement(int position){
        return product[position];
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", product=" + Arrays.toString(product) +
                '}';
    }
}
