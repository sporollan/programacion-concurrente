package tp04.ej4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        int numA = 3, numB = 2;
        Semaphore semImpresion = new Semaphore(0);
        Semaphore semImpresora = new Semaphore(1);
        Impresora imp = new Impresora(semImpresora, semImpresion);
        Thread impresora = new Thread(imp);
        impresora.start();
        while(true){
            Thread impresion = new Thread(new Impresion(imp, semImpresora, semImpresion));
            impresion.start();
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){}
        }
    }
}