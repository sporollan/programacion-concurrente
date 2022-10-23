package tpo.ej1;
import java.util.concurrent.*;;

public class controlBuque implements Runnable{
    private Buque buque;
    private Semaphore semBuque;
    public controlBuque(Buque buque, Semaphore semBuque){
        this.buque = buque;
        this.semBuque = semBuque;
    }

    public synchronized void w(){
        try{
            this.wait();
        } catch (InterruptedException e){}
        finally {}
    }

    public void run(){
        while(true){
            while(!buque.isFull()){
                this.buque.w();
            }
            buque.ir();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){}
            buque.volver();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){}

            semBuque.release();

        }
    }
}
