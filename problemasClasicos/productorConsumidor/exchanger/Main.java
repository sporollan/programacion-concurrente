package problemasClasicos.productorConsumidor.exchanger;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args){
        Exchanger<String> exchanger = new Exchanger<String>();

        for(int i = 0; i < 100; i++){
            Thread p = new Thread(new Productor(exchanger, i));
            p.start();
        }

        for(int i = 0; i < 100; i++){
            Thread c = new Thread(new Consumidor(exchanger, i));
            c.start();
        }

    }
}
