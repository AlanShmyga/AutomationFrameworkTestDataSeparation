package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    public static List<String> getProductNames() throws SQLException {
        String query = "SELECT name FROM 'lc_products_info'";
        ResultSet rs = executeQuery(query);
        List<String> response = new ArrayList<>();

        while (rs.next()) {
            response.add(rs.getString("name"));
        }
        return response;
    }

    private static ResultSet executeQuery(String query) {
        Connection connection = getDatabaseConnection();
        ResultSet response = null;
        try {
            response = connection.prepareStatement(query).executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static Connection getDatabaseConnection() {
        String databaseUrl = PropertyHelper.getProperty("dbUrl");
        String dbUser = PropertyHelper.getProperty("dbUser");
        String dbPassword = PropertyHelper.getProperty("dbPassword");
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.getDriver(PropertyHelper.getProperty("dbDriverUrl"));
            connection = DriverManager.getConnection(databaseUrl, dbUser, dbPassword);
        } catch (SQLException  e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
