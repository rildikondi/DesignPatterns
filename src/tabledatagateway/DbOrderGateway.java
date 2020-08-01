package tabledatagateway;

import java.sql.*;

public class DbOrderGateway implements OrderGateway {
    private final ProductGateway productGateway;
    private final Connection connection;

    public DbOrderGateway(Connection connection, ProductGateway productGateway) {
        this.connection = connection;
        this.productGateway = productGateway;
    }

    @Override
    public void insert(Order order) {
        try {
            int newMaxOrderId = getMaxOrderId() + 1;
            String sql = "INSERT INTO Orders(orderId, customerId) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newMaxOrderId);
            preparedStatement.setString(2, order.getCustomerId());
            order.setOrderId(newMaxOrderId);
            executeStatement(preparedStatement);
            insertItems(order);
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    private static void executeStatement(PreparedStatement statement) throws SQLException {
        statement.execute();
        statement.close();
    }

    public  int getMaxOrderId() throws SQLException {
        Statement qs = connection.createStatement();
        ResultSet resultSet = qs.executeQuery("SELECT MAX(orderId) from Orders");
        resultSet.next();
        int maxOrderId = resultSet.getInt(1);
        resultSet.close();
        return maxOrderId;
    }

    @Override
    public Order find(int id) {
        try {
            String sql = "SELECT * FROM Orders WHERE orderId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            if (resultSet.next()) {
                String customerId = resultSet.getString("customerId");
                order = new Order(customerId);
                order.setOrderId(id);
            }
            resultSet.close();
            if (order != null)
                loadItems(order);
            return order;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    private void loadItems(Order order) {
        try {
            String sql = "SELECT * FROM Items WHERE orderId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getOrderId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sku = resultSet.getString("sku");
                int quantity = resultSet.getInt("quantity");
                Product product = productGateway.find(sku);
                order.addItem(product, quantity);
            }
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    private void insertItems(Order order) throws SQLException {
        String sql = "INSERT INTO Items (orderId, quantity, sku)" +
                "VALUES (?, ?, ?)";
        for (Item item : order.getItems()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setString(3, item.getProduct().getSku());
            executeStatement(preparedStatement);
        }
    }
}
