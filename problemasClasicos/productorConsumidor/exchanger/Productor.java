package problemasClasicos.productorConsumidor.exchanger;
import java.util.concurrent.Exchanger;

public class Productor implements Runnable{
    private Exchanger<String> exchanger;
    private int n;

    public Productor(Exchanger<String> exchanger, int n){
        this.exchanger = exchanger;
        this.n = n;
    }

    public void run(){
        while(true){
            try{
                System.out.println(n + " produce");
                exchanger.exchange("producto " + n);
            } catch (InterruptedException e){};
        }
    }
}
