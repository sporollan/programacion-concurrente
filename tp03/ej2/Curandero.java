package tp03.ej2;
import java.util.Random;

public class Curandero extends Personaje{
    private int v = 3;

    public Curandero(Vida vida){
        super(vida);
    }

    public boolean accion(){
        Random r = new Random();
        try{
            Thread.sleep((r.nextInt(1)+1)*1000);
        } catch (InterruptedException e){};
        System.out.println("Curandero: Curar " + v + " puntos de vida");
        return super.modificar(v);

    }


}
