package tpo.ej1;
import java.util.concurrent.*;;

public class controlBuque implements Runnable{
    private Buque buque;
    private Semaphore semEmbarcar;

    public controlBuque(Buque buque, Semaphore semEmbarcar){
        this.buque = buque;
        this.semEmbarcar = semEmbarcar;
    }

    public void run(){
        while(true){
            // usa semEmbarcar para avisar que esta en la orilla
            this.semEmbarcar.release(10);

            // espera que lleguen autos. el auto le avisa y levanta la barrera
            this.buque.waitControl();
            this.buque.notifyBarrera();
            while(!buque.isFull()){
                // espera a que se llene
                this.buque.waitControl();
            }

            // realiza el viaje
            buque.ir();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}

            // levanta la barrera para que puedan bajar
            this.buque.notifyBarrera();
            while(!buque.isEmpty()){
                // espera hasta que este vacio
                this.buque.waitControl();
            }
            
            // realiza el viaje de vuelta
            buque.volver();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}

        }
    }
}
