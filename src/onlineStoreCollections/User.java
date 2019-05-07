package onlineStoreCollections;


import java.util.LinkedList;
import java.util.Objects;

public class User {
    private String login, password;
    private Basket userBasket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getUserBasket() {
        return userBasket;
    }

    public LinkedList<Product> getProductUserBasket() {
        return userBasket.getPurchasedGoods();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserBasket(Basket userBasket) {
        this.userBasket = userBasket;
    }

    public void authentication(String login, String password) {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Wrong login or password.");
            System.exit(0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userBasket, user.userBasket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, userBasket);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userBasket=" + userBasket +
                '}';
    }
}
