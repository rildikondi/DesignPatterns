package facade;


import java.util.HashMap;

public class SqlCommand {

    private HashMap<String, Object> parameters = new HashMap<>();
    private String sql;
    private SqlConnection connection;

    public SqlCommand(String sql, SqlConnection connection) {
        this.sql = sql;
        this.connection = connection;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void executeNonQuery() {

    }

    public IDataReader executeReader() {
       return new IDataReader();
    }
}
