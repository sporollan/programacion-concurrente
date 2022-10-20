package tp5.ej3;
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
        int numPermisos = 1;
        if(this.tipo == "perro")
            numPermisos = 2;
        while(!comio){
            try{
                mutex.acquire();
            } catch (InterruptedException e){}
            if(this.comedero.puedeComer(this.tipo)){
                if(semPropio.tryAcquire(numPermisos)){
                    this.comedero.increaseComiendo();
                    mutex.release();
                    this.comedero.comer(semPropio, semOtro);
                    this.comedero.decreaseComiendo();
                    comio = true;
                    semPropio.release(numPermisos);
                } else {
                    mutex.release();
                }
            } else {
                mutex.release();
            }
        }
      }
    }
