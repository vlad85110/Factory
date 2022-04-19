package thread;

import assembly.ProductController;
import dealers.Dealers;
import suppliers.CarBodySupplier;
import suppliers.EngineSupplier;
import suppliers.accessories.AccessoriesSuppliers;

public record Factory(AccessoriesSuppliers accessoriesSuppliers,
                      CarBodySupplier carBodySupplier, EngineSupplier engineSupplier,
                      Dealers dealers) {
    private static ProductController controller;

    public void start() {
        controller = ProductController.getInstance();

        accessoriesSuppliers.start();
        carBodySupplier.start();
        engineSupplier.start();
        dealers.start();
        controller.start();
    }

    public void end() {
        accessoriesSuppliers.end();
        carBodySupplier.end();
        engineSupplier.end();
        dealers.end();
        controller.end();

        System.exit(0);
    }
}
