package products;

public class CarBody extends Product {
    private static int id = 0;

    public CarBody() {
        name = "car body " + id;
        id++;
    }
}
