package tpo.ej1mejorado;

public class MonEmbarcar {
    public synchronized void w(){
        try{
            this.wait();
        } catch (InterruptedException e){}
    }

    public synchronized void n(){
        this.notify();
    }
}
