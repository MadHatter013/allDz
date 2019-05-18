package onlineStoreWithDatabase;

import java.sql.*;

import static onlineStoreWithDatabase.ConnectionData.*;

public class WriteFromDatabase {
    private static final String SELECT_QUERY = "Select * FROM productelectronics";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            System.out.printf("%-20s%-20s%-20s%-20s%n", "id", "product_name","price","rating");
            System.out.println("------------------------------------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                String price = resultSet.getString("price");
                String rating = resultSet.getString("rating");
                System.out.printf("%-20s%-20s%-20s%-20s%n", id, name, price, rating);
            }
            System.out.println("------------------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
