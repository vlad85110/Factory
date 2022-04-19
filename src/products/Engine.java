package products;

public class Engine extends Product {
    private static int id = 0;

    public Engine() {
        name = "engine " + id;
        id++;
    }
}
