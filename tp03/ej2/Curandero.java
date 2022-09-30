package tp03.ej2;

public class Curandero extends Personaje{
    private int p = 4;
    public Curandero(Datos datos){
        super(datos);
    }

    public int getValorP(){
        return this.p;
    }

    public void mostrarMensajeAccion(){
        System.out.println("Curandero: curando " + this.p + " puntos de vida");
    }

    public void mostrarMensajeExito(int vida){
        System.out.println("Curandero: finaliza accion con exito" + "\nNueva vida: " + 
        vida);
    }

    public void mostrarMensajeDuerme(){
        System.out.println("Curandero duerme");
    }
}