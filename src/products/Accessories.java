package products;

public class Accessories extends Product {
    private static int id = 0;

    public Accessories() {
        name = "accessories " + id;
        id++;
    }
}
