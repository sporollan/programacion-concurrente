package tpo.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Oxigeno implements Runnable{
    private Recipiente recipiente;
    private Semaphore semOxigeno;

    public Oxigeno(Recipiente recipiente, Semaphore semOxigeno){
        this.recipiente = recipiente;
        this.semOxigeno = semOxigeno;
    }
    public void run(){
        Random r = new Random();
        try{
            Thread.sleep(r.nextInt(100)*4000);
        } catch (InterruptedException e){}
        finally{};

        recipiente.addOlisto();
        semOxigeno.release();

    }
}
