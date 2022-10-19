package tp5.ej2;
import java.util.concurrent.*;

public class Animal implements Runnable{
    private Semaphore perroSem, gatoSem, mutex;
    private String tipo;
    private Comedero comedero;

    

    public Animal(String tipo, Semaphore gatoSem, Semaphore perroSem, Semaphore mutex, Comedero comedero){
        this.perroSem = perroSem;
        this.gatoSem = gatoSem;
        this.tipo = tipo;
        this.comedero = comedero;
        this.mutex = mutex;

    }

    public void run(){
        Boolean comio = false;
        while(!comio){
            if(this.tipo == "gato"){
                try{
                    mutex.acquire();
                } catch (InterruptedException e){}
                if(perroSem.availablePermits() == this.comedero.getLimite() && this.comedero.puedeComer()){
                    if(gatoSem.tryAcquire()){
                        mutex.release();
                        this.comedero.comer(gatoSem, perroSem);
                        comio = true;
                        gatoSem.release();
                    } else {
                        mutex.release();
                    }
                } else {
                    mutex.release();
                }

            } else if(this.tipo == "perro") {
                try{
                    mutex.acquire();
                } catch (InterruptedException e){}
                if(gatoSem.availablePermits() == this.comedero.getLimite() && this.comedero.puedeComer() ){
            
                    if(perroSem.tryAcquire()){
                        mutex.release();
                        this.comedero.comer(perroSem, gatoSem);
                        comio = true;
                        perroSem.release();
                    } else {
                        mutex.release();
                    }
                } else {
                    mutex.release();
                }
            }
      }

    }
}
