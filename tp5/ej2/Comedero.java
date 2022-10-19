package tp5.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Comedero {
    private int limite;
    private int comieron;
    public Comedero(int limite){
        this.limite = limite;
        this.comieron = 0;
    }

    public void comer(Semaphore s, Semaphore s2){
        Random r = new Random();
        System.out.println(Thread.currentThread().getName() + " comiendo..." + s.availablePermits() + s2.availablePermits());
        try{
            Thread.sleep(r.nextInt(5)*1000);
            comieron++;
        } catch(InterruptedException e){}
    }

    public int getLimite(){
        return this.limite;
    }

    public boolean puedeComer(){
        if(this.comieron == 10){
            this.comieron = 0;
            return false;
        } else {
            return true;
        }
    }
}
