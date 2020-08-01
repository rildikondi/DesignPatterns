package tabledatagateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbProductGateway implements ProductGateway {
    private final Connection connection;

    public DbProductGateway(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Product product) {
        try {
            PreparedStatement statement = buildInsertionStatement(product);
            executeStatement(statement);
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    @Override
    public Product find(String sku) {
        try {
            PreparedStatement statement = buildProductQueryCommand(sku);
            ResultSet resultSet = executeQueryStatement(statement);
            if (resultSet.next()) {
                Product product = extractProductFromResult(resultSet);
                statement.close();
                return product;
            }
            return null;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
    }

    private PreparedStatement buildProductQueryCommand(String sku) throws SQLException {
        String sql = "SELECT sku, name, price FROM Products WHERE sku = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, sku);
        return statement;
    }

    private ResultSet executeQueryStatement(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }

    private Product extractProductFromResult(ResultSet resultSet) throws SQLException {
        Product pd = new Product();
        pd.setSku(resultSet.getString(1));
        pd.setName(resultSet.getString(2));
        pd.setPrice(resultSet.getInt(3));
        return pd;
    }

    private PreparedStatement buildInsertionStatement(Product pd) throws SQLException {
        String sql = "INSERT INTO Products(sku, name, price) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pd.getSku());
        statement.setString(2, pd.getName());
        statement.setInt(3, pd.getPrice());
        return statement;
    }

    private void executeStatement(PreparedStatement statement) throws SQLException {
        statement.execute();
        statement.close();
    }
}
