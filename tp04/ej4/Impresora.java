package tp04.ej4;

import java.util.concurrent.Semaphore;

public class Impresora implements Runnable{
    private Semaphore semImpresora, semImpresion;
    public Impresora(Semaphore semImpresora, Semaphore semImpresion){
        this.semImpresora = semImpresora;
        this.semImpresion = semImpresion;
    }
    
    public void run(){
        while(true){
        try{
            semImpresora.acquire();
        } catch (InterruptedException e){}
            System.out.println("Imprimiendo");
            semImpresion.release();
        }
    }
}
