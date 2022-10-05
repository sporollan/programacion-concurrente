package problemasClasicos.filosofos;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable{
    private int num;
    private Semaphore derecho, izquierdo;

    public Filosofo(int num, Semaphore derecho, Semaphore izquierdo){
        this.num = num;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
    }

    private void comer(){
        if(this.num%2 == 0){
            try{    
                izquierdo.acquire();
                derecho.acquire();
            } catch (InterruptedException e){}
        } else {
            try{
                derecho.acquire();
                izquierdo.acquire();
            } catch(InterruptedException e){}
        }
        System.out.println("Filosofo "+ Thread.currentThread().getName() + " comiendo");
        this.dormir();
        izquierdo.release();
        derecho.release();
    }


    private void pensar(){
        System.out.println("Filosofo " + Thread.currentThread().getName() + " pensando");
        this.dormir();
    }

    private void dormir(){
        Random r = new Random();
        try{
            Thread.sleep(r.nextInt(5) * 1000);
        } catch (InterruptedException e) {}
    }

    public void run(){
        while(true){
            this.comer();
            this.pensar();
        }
    }
}
