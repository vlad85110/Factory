import assembly.ProductController;
import dealers.Dealers;
import suppliers.CarBodySupplier;
import suppliers.EngineSupplier;
import suppliers.accessories.AccessoriesSuppliers;

public class Main {

    public static void main(String[] args) {
        AccessoriesSuppliers accessoriesSuppliers = new AccessoriesSuppliers();
        accessoriesSuppliers.start();
        CarBodySupplier carBodySupplier = new CarBodySupplier("car body");
        carBodySupplier.start();
        EngineSupplier engineSupplier = new EngineSupplier("engine");
        engineSupplier.start();

        ProductController controller = ProductController.getInstance();
        controller.start();

        Dealers dealers = new Dealers();
        dealers.start();
    }
}
