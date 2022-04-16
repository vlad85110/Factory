package parse;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Parser {
    private static final Properties properties = new Properties();

    static {
        FileReader reader;
        try {
            reader = new FileReader("src/parse/params.config");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int parse(String field) {
        return Integer.parseInt(properties.getProperty(field));
    }

}
