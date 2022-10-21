package tp5.ej5;

public class Pista {
    public String[] enTierra;
    public int tope;
    public Pista(){
        enTierra = new String[100];
        tope = 0;
    }

    public void aterrizar(){
        System.out.println("Aterrizando " + Thread.currentThread().getName());
    }

    public void salirDePista(){
        System.out.println("Saliendo de la pista " + Thread.currentThread().getName());
        enTierra[tope] = Thread.currentThread().getName();
        tope++;
    }

    public void almacenar(){
        System.out.println("Almacenando " + Thread.currentThread().getName());
        enTierra[tope] = "";
        tope--;
    }
}
