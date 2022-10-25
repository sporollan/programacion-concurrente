package tpo.ej1;
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

    public void run(){
        try{
            // semEmbarcar para esperar al barco
            semEmbarcar.acquire();
        } catch (InterruptedException e){}
        // le avisa al barco y espera a que levante la barrera
        this.buque.notifyControl();
        this.buque.waitBarrera();
        this.embarcar();

        if(!this.buque.isFull())
            // le avisa al auto proximo que puede subir
            this.buque.notifyBarrera();

        // le avisa al buque que subio
        this.buque.notifyControl();

        // espera a que levanten la barrera para desembarcar
        this.buque.waitBarrera();
        this.desembarcar();
        if(!this.buque.isEmpty())
            // avisa al auto proximo que puede bajar
            this.buque.notifyBarrera();
        // avisa al buque que bajo
        this.buque.notifyControl();

    }
}
