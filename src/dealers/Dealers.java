package dealers;

import storages.ProductStorage;

import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers;

    public Dealers(int size, ProductStorage storage) {
        dealers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            dealers.add(new Dealer(storage));
        }
    }
}
