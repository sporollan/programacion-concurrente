package tpo.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Oxigeno implements Runnable{
    private Recipiente recipiente;
    private Semaphore olisto;

    public Oxigeno(Recipiente recipiente, Semaphore olisto){
        this.recipiente = recipiente;
        this.olisto = olisto;
    }
    public void run(){
        Random r = new Random();
        try{
            // simula que flota por un tiempo
            Thread.sleep(r.nextInt(100)*1000);
        } catch (InterruptedException e){}
        finally{};

        // ingresa en el recipiente y notifica al generador
        recipiente.addOlisto();
        this.recipiente.notifyGenerador();
        try{
            // espera hasta hasta que se complete el proceso hacer agua
            this.olisto.acquire();
        } catch (InterruptedException e){}
        System.out.println("Oxigeno consumido");

    }
}
