package tp6.ej1;

public class Coche implements Runnable{
    private int direccion;
    private Puente puente;
    public Coche(int direccion, Puente puente){
        this.direccion = direccion;
        this.puente = puente;
    }
    public void run(){
        this.puente.esperar(direccion);
        this.puente.cruzar(direccion);
        this.puente.comprobarPaso(direccion);
    }
}
