package tp03.ej2;

import java.util.Random;

public class Orco extends Personaje{
    private int v = 5;

    public Orco(Vida vida){
        super(vida);   
    }

    public boolean accion(){
        Random r = new Random();
        try{
            Thread.sleep((r.nextInt(4)+1)*1000);
        } catch (InterruptedException e){};
        System.out.println("Orco: quitar " + v + " puntos de vida");
        return super.modificar(-v);

    }
}
