package facade;


import java.util.HashMap;

public class SqlCommand {

    private HashMap<String, Object> parameters;

    public SqlCommand(String sql, SqlConnection connection) {
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
