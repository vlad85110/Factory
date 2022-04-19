package products;

public class Car extends Product {
    private static int id = 0;

    public Car(Engine engine, CarBody carBody, Accessories accessories) {
        name = "car " + id + ":(" + carBody.getName() + " " + engine.getName() + " " + accessories.getName() + ")";
        id++;
    }
}
