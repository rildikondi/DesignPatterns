package facade;

import java.util.HashMap;

public class IDataReader {
    private HashMap<String, Object> parameters;

    public Object getKey(String key) {
        return parameters.get(key);
    }

    public void close() {
    }

    public void read() {
    }
}
