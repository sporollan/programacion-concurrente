package tp03.ej2;

public class Curandero extends Personaje{

    public Curandero(Vida v){
        super(v);
    }

    public void curar(int v){
        System.out.println("Curandero: Curar " + v + " puntos de vida");
        super.modificar(v);
    }

    public void run(){
        this.curar(3);
    }
}
