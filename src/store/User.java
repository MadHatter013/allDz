package store;

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
        if (this.login == login.intern() & this.password == password.intern()){
            System.out.println("Login successful.");
        }else {
            System.out.println("Wrong login or password.");
            System.exit(0);
        }
    }
}
