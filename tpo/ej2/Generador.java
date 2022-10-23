package tpo.ej2;
import java.util.concurrent.*;

public class Generador implements Runnable{
    private Semaphore semOxigeno, semHidrogeno;
    private Recipiente recipiente;

    public Generador(Recipiente recipiente, Semaphore semHidrogeno, Semaphore semOxigeno){
        this.recipiente = recipiente;
        this.semHidrogeno = semHidrogeno;
        this.semOxigeno = semOxigeno;
    }
    public void run(){
        while(true){
            try{
                this.semHidrogeno.acquire(2);
                this.semOxigeno.acquire(1);
            } catch (InterruptedException e){}
            System.out.println("generando agua");
            this.recipiente.hacerAgua();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            this.recipiente.show();
            this.recipiente.comprobarLleno();
        }

    }
}
