package tpo.ej1mejorado;
import java.util.concurrent.*;

public class Auto implements Runnable{
    private Buque buque;
    private Semaphore semEmbarcar;

    public Auto(Buque buque, Semaphore semEmbarcar){
        this.buque = buque;
        this.semEmbarcar = semEmbarcar;
    }

    public void embarcar(){
        System.out.println("embarcando");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){}
        this.buque.addAuto();
    }

    public void desembarcar(){
        System.out.println("desembarcando");
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){};
        this.buque.rmAuto();
    }

    public synchronized void n(){
        this.notify();
    }

    public void run(){

        while(buque.isFull()){
            this.monEmbarcar.w();
        }

        try{
            semEmbarcar.acquire();
        } catch (InterruptedException e){}
        this.embarcar();

        if(!buque.isFull()){
            semEmbarcar.release();
        } else {
            this.buque.n();
        }

    }
}
