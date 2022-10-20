package tp5.ej2;
import java.util.concurrent.*;
import java.util.Random;

public class Comedero {
    private int limite;
    private int comiendo;
    private int comieron;
    private String tipo;
    public Comedero(int limite){
        this.limite = limite;
        this.comieron = 0;
        this.comiendo = 0;
        this.tipo = "perro";
    }

    public void comer(Semaphore s, Semaphore s2){
        Random r = new Random();
        System.out.println(Thread.currentThread().getName() + " comiendo..." + s.availablePermits() + s2.availablePermits());
        try{
            Thread.sleep(r.nextInt(5)*1000);
            comieron++;
        } catch(InterruptedException e){}
    }

    public int getLimite(){
        return this.limite;
    }

    public boolean puedeComer(String animal){
        boolean puede;
        puede = (this.tipo == animal);
        if(puede && this.comieron > 10){
            if(animal == "perro")
                this.tipo = "gato";
            else
                this.tipo = "perro";
            this.comieron = 0;
            puede = false;
        }
        return puede;
    }

    public void increaseComiendo(){
        this.comiendo++;
    }

    public void decreaseComiendo(){
        this.comiendo--;
    }

}
