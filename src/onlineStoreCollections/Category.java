package onlineStoreCollections;

import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    List<Product> product;

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void showCatalog() {
        System.out.println(name + ":");
        for (int i = 0; i < product.size(); i++) {
            System.out.print(i + 1 + ": ");
            product.get(i).toString();
        }
        System.out.println();
    }

    public Product getSpecificArrayElement(int position) {
        return product.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(product, category.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, product);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
