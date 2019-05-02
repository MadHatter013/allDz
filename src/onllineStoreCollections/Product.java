package onllineStoreCollections;

import java.util.Objects;

public class Product {
    private String name;
    private double prise, rating;
    private String nameCategory;

    public Product(String name, double prise, double rating) {
        this.name = name;
        this.prise = prise;
        this.rating = rating;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void showProduct() {
        System.out.println("Товар: " + this.getName() + "\n Цена: " + this.getPrise() + " Рейтинг: " + this.getRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.prise, prise) == 0 &&
                Double.compare(product.rating, rating) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(nameCategory, product.nameCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prise, rating, nameCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", prise=" + prise +
                ", rating=" + rating +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
