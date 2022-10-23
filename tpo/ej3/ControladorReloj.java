package tpo.ej3;

public class ControladorReloj implements Runnable{
    private Reloj reloj;
    public ControladorReloj(Reloj reloj){
        this.reloj = reloj;
    }
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            this.reloj.increase();
        }
    }
}
