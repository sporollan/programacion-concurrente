package tpo.ej1;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Buque buque = new Buque();
        Semaphore semBuque = new Semaphore(1);
        Thread controlBuque = new Thread(new controlBuque(buque, semBuque));
        for(int i = 0; i<115; i++){
            Thread auto = new Thread(new Auto(buque, semBuque));
            auto.start();
        }
        controlBuque.start();

    }
}
