package problemasClasicos.productorConsumidor;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Buffer buffer = new Buffer();
        Semaphore prodSem = new Semaphore(7);
        Semaphore consSem = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        for(int i = 0; i < 2; i++){
            Thread productor = new Thread(new Productor(buffer, prodSem, consSem, mutex));
            productor.start();
        }
        for(int i = 0; i < 4; i++){
            Thread consumidor = new Thread(new Consumidor(buffer, prodSem, consSem, mutex));
            consumidor.start();
        }
        while(true){
            try{
                Thread.sleep(500);
                buffer.show();
            } catch (InterruptedException e){}
        }
    }
}
