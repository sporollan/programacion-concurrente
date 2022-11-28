package problemasClasicos.productorConsumidor.exchanger;
import java.util.concurrent.Exchanger;

public class Consumidor implements Runnable{
    private Exchanger<String> exchanger;
    private int n;

    public Consumidor(Exchanger<String> exchanger, int n){
        this.exchanger = exchanger;
        this.n = n;
    }

    public void run(){
        String s;
        while(true){
            try{
                s = exchanger.exchange(new String());
                System.out.println(n + " consume " + s);
            } catch (InterruptedException e){};
        }
    }
}
