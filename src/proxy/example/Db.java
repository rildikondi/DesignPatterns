package proxy.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private static Connection connection;

    public static void init() throws Exception {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Amarildo\\Desktop\\shoppingCart.mdb", "", "");
    }

    public static void store(ProductData pd) throws Exception {
        PreparedStatement statement = buildInsertionStatement(pd);
        executeStatement(statement);
    }

    private static PreparedStatement buildInsertionStatement(ProductData pd) throws SQLException {
        String sql = "INSERT INTO Products(sku, name, price) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pd.getSku());
        statement.setString(2, pd.getName());
        statement.setInt(3, pd.getPrice());
        return statement;
    }

    public static ProductData getProductData(String sku) throws Exception {
        PreparedStatement statement = buildProductQueryCommand(sku);
        ResultSet resultSet = executeQueryStatement(statement);
        ProductData productData = extractProductDataFromResult(resultSet);
        statement.close();
        return productData;
    }

    private static PreparedStatement buildProductQueryCommand(String sku) throws SQLException {
        String sql = "SELECT sku, name, price  FROM Products WHERE sku = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, sku);
        return statement;
    }

    private static ProductData extractProductDataFromResult(ResultSet resultSet) throws SQLException {
        ProductData pd = new ProductData();
        pd.setSku(resultSet.getString(1));
        pd.setName(resultSet.getString(2));
        pd.setPrice(resultSet.getInt(3));
        return pd;
    }

    public static void deleteProductData(String sku) throws Exception {
        executeStatement(buildProductDeleteStatement(sku));
    }

    private static PreparedStatement buildProductDeleteStatement(String sku) throws SQLException {
        String sql = "DELETE from Products WHERE sku = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, sku);
        return statement;
    }

    private static void executeStatement(PreparedStatement statement) throws SQLException {
        statement.execute();
        statement.close();
    }

    private static ResultSet executeQueryStatement(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;
    }

    public static void close() throws Exception {
        connection.close();
    }

    public static OrderData newOrder(String customerId) throws SQLException {
        int newMaxOrderId = getMaxOrderId() + 1;
        String sql = "INSERT INTO Orders(orderId, customerId) VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, newMaxOrderId);
        preparedStatement.setString(2, customerId);
        executeStatement(preparedStatement);
        return new OrderData(newMaxOrderId, customerId);
    }

    private static int getMaxOrderId() throws SQLException {
        Statement qs = connection.createStatement();
        ResultSet resultSet = qs.executeQuery("SELECT MAX(orderId) from Orders");
        resultSet.next();
        int maxOrderId = resultSet.getInt(1);
        resultSet.close();
        return maxOrderId;
    }

    public static void store(ItemData id) throws Exception {
        PreparedStatement preparedStatement = buildItemInsertionStatement(id);
        executeStatement(preparedStatement);
    }

    private static PreparedStatement
    buildItemInsertionStatement(ItemData id) throws SQLException {
        String sql = "INSERT INTO Items(orderId,quantity,sku) " +
                "VALUES (?, ?, ?)";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setInt(1, id.orderId);
        command.setInt(2, id.qty);
        command.setString(3, id.sku);
        return command;
    }

    public static ItemData[] getItemsForOrder(int orderId) throws Exception {
        PreparedStatement preparedStatement = buildItemsForOrderQueryStatement(orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        ItemData[] id = extractItemDataFromResultSet(resultSet);
        resultSet.close();
        preparedStatement.close();
        return id;
    }

    private static PreparedStatement
    buildItemsForOrderQueryStatement(int orderId) throws SQLException {
        String sql = "SELECT * FROM Items " +
                "WHERE orderId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, orderId);
        return preparedStatement;
    }

    private static ItemData[]
    extractItemDataFromResultSet(ResultSet resultSet) throws SQLException {
        List<ItemData> items = new ArrayList<>();
        while (resultSet.next()) {
            int orderId = resultSet.getInt("orderId");
            int quantity = resultSet.getInt("quantity");
            String sku = resultSet.getString("sku");
            ItemData id = new ItemData(orderId, quantity, sku);
            items.add(id);
        }
        ItemData[] itemsArray = new ItemData[items.size()];
        itemsArray = items.toArray(itemsArray);
        return itemsArray;
    }

    public static OrderData getOrderData(int orderId) throws SQLException {
        String sql = "SELECT customerId FROM Orders " +
                "WHERE orderId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        OrderData od = null;
        if (resultSet.next())
            od = new OrderData(orderId, resultSet.getString("customerId"));
        resultSet.close();
        preparedStatement.close();
        return od;
    }

    public static void clear() throws SQLException {
        executeSql("DELETE FROM Items");
        executeSql("DELETE FROM Orders");
        executeSql("DELETE FROM Products");
    }

    private static void executeSql(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        executeStatement(preparedStatement);
    }
}