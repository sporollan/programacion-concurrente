package tp04.ej4;

import java.util.concurrent.Semaphore;

public class Impresion implements Runnable{
    private Impresora impresora;
    private Semaphore semImpresora, semImpresion;
    public Impresion(Impresora impresora, Semaphore semImpresora, Semaphore semImpresion){
        this.impresora = impresora;
        this.semImpresora = semImpresora;
        this.semImpresion = semImpresion;
    }
    public void run(){
        try{
            semImpresion.acquire();
        } catch (InterruptedException e){}
        semImpresora.release();
        System.out.println("Siendo impreso " + Thread.currentThread().getName());
    }
}
