package tpo.ej1;

public class Mon {
    public synchronized void w(){
        try{
            this.wait();
        } catch (InterruptedException e){}
    }
    public synchronized void n(){
        this.notify();
    }
}
