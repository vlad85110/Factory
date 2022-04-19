import dealers.Dealers;
import suppliers.CarBodySupplier;
import suppliers.EngineSupplier;
import suppliers.accessories.AccessoriesSuppliers;
import thread.Factory;
import view.Viewer;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory(new AccessoriesSuppliers(), new CarBodySupplier("car body"),
                new EngineSupplier("engine"), new Dealers());

        factory.start();

        var viewer = Viewer.getInstance();
        viewer.connect(factory);
    }

}
