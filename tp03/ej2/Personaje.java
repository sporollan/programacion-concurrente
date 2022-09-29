package tp03.ej2;
import java.util.Random;
public class Personaje extends Thread{
    private Vida vida;

    public Personaje(Vida vida){
        this.vida = vida;
    }

    public boolean modificar(int v){
        boolean f = this.vida.modificar(v);
        System.out.println("Nueva vida: " + this.vida.getVida());
        return f;
    }

    public boolean accion(){
        return true;
    }

    public void run(){
        boolean f = true;
        while(f){
            try{
                f = this.accion();
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
        System.out.println("Vida ha llegado a cero");
    }
}
