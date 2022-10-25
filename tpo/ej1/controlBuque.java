package tpo.ej1;
import java.util.concurrent.*;;

public class controlBuque implements Runnable{
    private Buque buque;
    private Semaphore semBuque;

    public controlBuque(Buque buque, Semaphore semBuque){
        this.buque = buque;
        this.semBuque = semBuque;
    }

    public void run(){
        while(true){
            while(!buque.isFull()){
                this.buque.waitControl();
            }
            buque.ir();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            this.buque.notifyBarrera();
            while(!buque.isEmpty()){
                this.buque.waitControl();
            }

            buque.volver();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}

            semBuque.release();

        }
    }
}
