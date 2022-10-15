package problemasClasicos.productorConsumidor;
import java.util.concurrent.*;

public class Productor implements Runnable{
    private Semaphore mutex, prodSem, consSem;
    private Buffer buffer;

    public Productor(Buffer buffer,Semaphore prodSem, Semaphore consSem, Semaphore mutex){
        this.buffer = buffer;
        this.prodSem = prodSem;
        this.consSem = consSem;
        this.mutex = mutex;
    }

    public void producir(){
        System.out.println("Producir producto " + Thread.currentThread().getName());
        buffer.add("x");
    }

    public void run(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){}
        while (true){
            try{
                this.prodSem.acquire();
                this.mutex.acquire();
                this.producir();
                this.consSem.release();
                this.mutex.release();
                Thread.sleep(2000);
            } catch (InterruptedException e){}
        }
    }
}
