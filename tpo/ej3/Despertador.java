package tpo.ej3;

public class Despertador {
    public synchronized void w(){
        try{
            this.wait();
        } catch (InterruptedException e){}
    }
    public synchronized void n(){
        this.notify();
    }
}
