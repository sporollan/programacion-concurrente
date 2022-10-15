package problemasClasicos.productorConsumidor;
import java.util.concurrent.*;

public class Consumidor implements Runnable{
    private Semaphore mutex, prodSem, consSem;
    private Buffer buffer;

    public Consumidor(Buffer buffer,Semaphore prodSem, Semaphore consSem, Semaphore mutex){
        this.buffer = buffer;
        this.prodSem = prodSem;
        this.consSem = consSem;
        this.mutex = mutex;
    }

    public void consumir(){
        System.out.println("Consumiendo " + this.buffer.pop());
    }

    public void run(){
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){}
        while(true){
            try{
                this.consSem.acquire();
                this.mutex.acquire();
                this.consumir();
                this.mutex.release();
                this.prodSem.release();
                Thread.sleep(3000);
            } catch (InterruptedException e){}
        }
    }


}
