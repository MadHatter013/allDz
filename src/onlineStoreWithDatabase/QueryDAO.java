package onlineStoreWithDatabase;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class QueryDAO {

    public List<Product> findAll(String s) {

        String QUERY = "SELECT * FROM ";
        QUERY = QUERY + s;

        List<Product> list = new LinkedList<>();
        try (Connection connection = ConnectionDB.getConnection();
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
            e.getMessage();
        }
        return list;
    }

    public Product findEntityById(String s, Integer id) {
        String QUERY = "SELECT * FROM ";
        QUERY = QUERY + s + " WHERE id=?";
        Product product = null;
        try (Connection connection = ConnectionDB.getConnection();
             Statement statement = connection.prepareStatement(QUERY)) {
            ((PreparedStatement) statement).setInt(1, id);
            ResultSet resultSet = ((PreparedStatement) statement).executeQuery();
            if (resultSet.next()) {
//                String name = resultSet.getString(2);
                product = new Product(resultSet.getString("product_name"),
                        resultSet.getDouble("price"), resultSet.getDouble("rating"));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return product;
    }

    public void addProductToBasket(String s, int id) {
        Product product = findEntityById(s, id);
        String query = "INSERT INTO purchasedgoods(product_name, price, rating)" + " VALUES (?,?,?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrise());
            preparedStatement.setDouble(3,product.getRating());

            preparedStatement.execute();
//            QUERY = QUERY + product.getName() + ", " + product.getPrise() + ", " + product.getRating() + ")";
//            preparedStatement.executeQuery(query);

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void cleatBasket(){
        String query = "DELETE FROM purchasedgoods";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.execute();
        }catch (SQLException e){
            e.getMessage();
        }
    }
}
