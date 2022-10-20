package tp5.ej4;
import java.util.concurrent.*;

public class ControlTren implements Runnable{
    private Semaphore semTren, semTickets;
    private Tren tren;

    public ControlTren(Tren tren, Semaphore semTren, Semaphore semTickets){
        this.semTren = semTren;
        this.tren = tren;
        this.semTickets = semTickets;
    }
    
    public void run(){
        while(true){
            try{
                semTren.acquire();
                System.out.println("Realizando paseo...");
                this.tren.show();
                Thread.sleep(1000);
                this.tren.initLugares();
                semTickets.release(10);
            } catch (InterruptedException e){
                System.out.println("semTickets, controlTren");
            }
        }
    }
}