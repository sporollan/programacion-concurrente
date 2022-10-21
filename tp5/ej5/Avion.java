package tp5.ej5;
import java.util.concurrent.*;
import java.util.Random;

public class Avion implements Runnable{
    private Semaphore torreSem, avionSem, pistaSem;
    private Pista pista;
    public Avion(Pista pista, Semaphore ts, Semaphore as, Semaphore ps){
        this.pista = pista;
        this.torreSem = ts;
        this.avionSem = as;
        this.pistaSem = ps;
    }

    public void run(){
        Random r = new Random();
        try{
            Thread.sleep((r.nextInt(10))*5000);
        } catch (InterruptedException e){};
        System.out.println(Thread.currentThread().getName() + " solicitando aterrizar");
        torreSem.release();
        try{
            System.out.println(Thread.currentThread().getName() + " esperando aprobacion");
            avionSem.acquire();
        } catch (InterruptedException e){}

        this.pista.aterrizar();
        try{
            Thread.sleep((r.nextInt(7)+5) * 1000);
        } catch (InterruptedException e){}        
        this.pista.salirDePista();
        pistaSem.release();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){}
        this.pista.almacenar();
    }
    
}
