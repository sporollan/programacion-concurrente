package tp03.ej2;

public class Orco extends Personaje{

    public Orco(Vida v){
        super(v);   
    }

    public void atacar(int v){
        System.out.println("Orco: quitar " + v + " puntos de vida");
        super.modificar(-v);

    }

    public void run(){
        this.atacar(3);
    }
}
