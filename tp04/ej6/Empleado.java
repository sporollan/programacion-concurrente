package tp04.ej6;

import java.util.concurrent.Semaphore;

public class Empleado implements Runnable{
    Semaphore sem;
    Semaphore sem2;

    public Empleado(Semaphore sem, Semaphore sem2){
        this.sem = sem;
        this.sem2 = sem2;
    }

    public void run(){
        while(true){
            // despierta al mozo y se duerme
            System.out.println("Pedir comida");
            this.sem2.release();
            try{
                this.sem.acquire();
            } catch(InterruptedException e){}
            System.out.println("Finaliza comida");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

        }
    }
}
