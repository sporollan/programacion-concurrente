package tp5.ej5;
import java.util.concurrent.*;

public class Torre implements Runnable {
    private Semaphore torreSem, avionSem, pistaSem;
    public Torre(Semaphore torreSem, Semaphore avionSem, Semaphore pistaSem){
        this.torreSem = torreSem;
        this.avionSem = avionSem;
        this.pistaSem = pistaSem;
    }
    public void run(){
        while(true){
            System.out.println("Torre en espera...");
            try{
                torreSem.acquire();
            } catch (InterruptedException e){}

            System.out.println("Torre autorizando aterrizaje");
            avionSem.release();

            try{
                System.out.println("Torre esperando que se libere la pista");
                pistaSem.acquire();
                System.out.println("Pista liberada");
            } catch (InterruptedException e){}
        }
    }
}
