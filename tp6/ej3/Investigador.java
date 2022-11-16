package tp6.ej3;
import java.util.Random;
public class Investigador implements Runnable{
    private Observatorio o;
    private String n;

    public Investigador(Observatorio o, String n){
        this.o = o;
        this.n = n;
    }
    public void run(){
        Random r = new Random();

        while(true){
            
        try{
            Thread.sleep((r.nextInt(5)+5)*1000);
            this.o.investigar(n);
        } catch (InterruptedException e){}
    }
    }
    
}