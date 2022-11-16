package tp6.ej3;
import java.util.Random;
public class Mantenimiento implements Runnable{
    private Observatorio o;
    private String n;

    public Mantenimiento(Observatorio o, String n){
        this.o = o;
        this.n = n;
    }
    public void run(){
        Random r = new Random();
        while(true){

            try{
                Thread.sleep((r.nextInt(5)+5)*1000);
                this.o.mantener(n);

            } catch (InterruptedException e){}
        }
    }
    
}
