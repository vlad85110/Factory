package parse;

public record FactoryConfig(int storageBodySize, int storageEngineSize, int storageAccessorySize, int storageAutoSize,
                            int accessorySuppliers, int workers, int dealers, boolean logSale) {
}
