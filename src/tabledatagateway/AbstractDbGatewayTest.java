package tabledatagateway;

import java.sql.*;

public class AbstractDbGatewayTest {
    protected Connection connection;
    protected DbProductGateway gateway;
    protected ResultSet resultSet;

    protected void executeSql(String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    protected void openConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Amarildo\\Desktop\\shoppingCart.mdb", "", "");
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    protected void close() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }
}
