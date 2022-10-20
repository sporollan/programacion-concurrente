package tp5.ej2;
import java.util.concurrent.*;

public class Animal implements Runnable{
    private Semaphore semOtro, semPropio, mutex;
    private String tipo;
    private Comedero comedero;

    

    public Animal(String tipo, Semaphore semPropio, Semaphore semOtro, Semaphore mutex, Comedero comedero){
        this.semOtro = semOtro;
        this.semPropio = semPropio;
        this.tipo = tipo;
        this.comedero = comedero;
        this.mutex = mutex;

    }

    public void run(){
        Boolean comio = false;
        while(!comio){
            try{
                mutex.acquire();
            } catch (InterruptedException e){}
            if(this.comedero.puedeComer(this.tipo)){
                if(semPropio.tryAcquire()){
                    this.comedero.increaseComiendo();
                    mutex.release();
                    this.comedero.comer(semPropio, semOtro);
                    this.comedero.decreaseComiendo();
                    comio = true;
                    semPropio.release();
                } else {
                    mutex.release();
                }
            } else {
                mutex.release();
            }
        }
      }
    }
