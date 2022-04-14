package parse;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Parser {
    private final FactoryConfig config;

    public Parser() throws IOException {
        Properties properties = new Properties();
        var reader = new FileReader("params.config");
        properties.load(reader);

        int storageBodySize = Integer.parseInt(properties.getProperty("storageBodySize"));
        int storageEngineSize = Integer.parseInt(properties.getProperty("storageEngineSize"));
        int storageAccessorySize = Integer.parseInt(properties.getProperty("storageAccessorySize"));
        int storageAutoSize = Integer.parseInt(properties.getProperty("storageAutoSize"));
        int accessorySuppliers = Integer.parseInt(properties.getProperty("accessorySuppliers"));
        int workers = Integer.parseInt(properties.getProperty("workers"));
        int dealers = Integer.parseInt(properties.getProperty("dealers"));
        boolean logSale = Boolean.parseBoolean(properties.getProperty("logSale"));

        config = new FactoryConfig(storageBodySize,storageEngineSize,storageAccessorySize,storageAutoSize,
                accessorySuppliers, workers, dealers, logSale);
    }

    public FactoryConfig getConfig() {
        return config;
    }
}
