package tpo.ej1;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Buque buque = new Buque();
        Semaphore semEmbarcar = new Semaphore(0);
        Thread controlBuque = new Thread(new controlBuque(buque, semEmbarcar));
        for(int i = 0; i<110; i++){
            Thread auto = new Thread(new Auto(buque, semEmbarcar));
            auto.start();
        }
        controlBuque.start();

    }
}
