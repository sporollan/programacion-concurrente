package tpo.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Hidrogeno implements Runnable{
    private Recipiente recipiente;
    private Semaphore hlisto;

    public Hidrogeno(Recipiente recipiente, Semaphore hlisto){
        this.recipiente = recipiente;
        this.hlisto = hlisto;
    }
    public void run(){
        Random r = new Random();
        try{
            // simula que flota por un tiempo
            Thread.sleep(r.nextInt(100)*1000);
        } catch (InterruptedException e){}
        finally{};

        // ingresa en el recipiente y notifica al generador
        recipiente.addHlisto();
        this.recipiente.notifyGenerador();
        try{
            // espera hasta hasta que se complete el proceso hacer agua
            this.hlisto.acquire();
        } catch (InterruptedException e){}
        System.out.println("Hidrogeno consumido");
        
    }
}
