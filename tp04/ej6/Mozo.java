package tp04.ej6;

import java.util.concurrent.Semaphore;

public class Mozo implements Runnable{
    Semaphore sem;
    Semaphore sem2;

    public Mozo(Semaphore sem, Semaphore sem2){
        this.sem = sem;
        this.sem2 = sem2;
    }

    public void run(){
        // espera que venga un cliente
        while(true){
            try{
                System.out.println("esperar cliente");
                this.sem.acquire();
            } catch(InterruptedException e){}            
            System.out.println("Sirviendo a cliente");
            try{
                Thread.sleep(1000);
            } catch( InterruptedException e){}
            System.out.println("Cliente servido");
            this.sem2.release();
        }
    }
}
