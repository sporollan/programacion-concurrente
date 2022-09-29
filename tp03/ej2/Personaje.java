package tp03.ej2;

public class Personaje extends Thread{
    private Vida vida;

    public Personaje(Vida vida){
        this.vida = vida;
    }

    public void modificar(int v){
        this.vida.modificar(v);
        System.out.println("Nueva vida: " + this.vida.getVida());
    }

}
