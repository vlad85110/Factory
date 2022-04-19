package dealers;

import parse.FactoryConfig;
import thread.AbstractFactoryThread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers;
    private final int size;

    public Dealers() {
        size = FactoryConfig.dealers;
        dealers = new ArrayList<>(size);
    }

    public void start() {
        FileWriter writer = null;
        try {
            writer= new FileWriter("src/dealers/log");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < size; i++) {
            dealers.add(new Dealer("Dealer-" + i, writer));
        }
        dealers.forEach(AbstractFactoryThread::start);
    }

    public void end() {
        dealers.forEach(Dealer::end);
    }
}
