package facade;

public class Db {
    //acts as FACADE

    private static SqlConnection connection;

    public static void init() {
        String connectionString =
                "Initial Catalog=QuickyMart;" +
                        "Data Source=marvin;" +
                        "user id=sa;password=abc;";
        connection = new SqlConnection(connectionString);
        connection.open();
    }

    public static void store(ProductData pd) {
        SqlCommand command = buildInsertionCommand(pd);
        command.executeNonQuery();
    }

    private static SqlCommand buildInsertionCommand(ProductData pd) {
        String sql = "INSERT INTO Products VALUES (@sku, @name, @price)";
        SqlCommand command = new SqlCommand(sql, connection);
        command.getParameters().put("@sku", pd.getSku());
        command.getParameters().put("@name", pd.getName());
        command.getParameters().put("@price", pd.getPrice());
        return command;
    }

    public static ProductData getProductData(String sku) {
        SqlCommand command = buildProductQueryCommand(sku);
        IDataReader reader = executeQueryStatement(command);
        ProductData pd = extractProductDataFromReader(reader);
        reader.close();
        return pd;
    }

    private static SqlCommand buildProductQueryCommand(String sku) {
        String sql = "SELECT * FROM Products WHERE sku = @sku";
        SqlCommand command = new SqlCommand(sql, connection);
        command.getParameters().put("@sku", sku);
        return command;
    }

    private static ProductData extractProductDataFromReader(IDataReader reader) {
        ProductData pd = new ProductData();
        pd.setPrice(Integer.parseInt(reader.getKey("price").toString()));
        pd.setName(reader.getKey("name").toString());
        pd.setSku(reader.getKey("price").toString());
        return pd;
    }

    public static void deleteProductData(String sku) {
        buildProductDeleteStatement(sku).executeNonQuery();
    }

    private static SqlCommand buildProductDeleteStatement(String sku) {
        String sql = "DELETE from Products WHERE sku = @sku";
        SqlCommand command = new SqlCommand(sql, connection);
        command.getParameters().put("@sku", sku);
        return command;
    }

    private static IDataReader executeQueryStatement(SqlCommand command) {
        IDataReader reader = command.executeReader();
        reader.read();
        return reader;
    }

    public static void close() {
        connection.close();
    }
}
