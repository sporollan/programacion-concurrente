package tpo.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Hidrogeno implements Runnable{
    private Recipiente recipiente;
    private Semaphore semHidrogeno;

    public Hidrogeno(Recipiente recipiente, Semaphore semHidrogeno){
        this.recipiente = recipiente;
        this.semHidrogeno = semHidrogeno;
    }
    public void run(){
        Random r = new Random();
        try{
            Thread.sleep(r.nextInt(100)*2000);
        } catch (InterruptedException e){}
        finally{};

        recipiente.addHlisto();
        semHidrogeno.release();
        
    }
}
