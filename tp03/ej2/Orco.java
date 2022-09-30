package tp03.ej2;

public class Orco extends Personaje{
    private int p = -5;
    public Orco(Datos datos){
        super(datos);
    }

    public int getValorP(){
        return this.p;
    }

    public void mostrarMensajeAccion(){
        System.out.println("Orco: quitando " + this.p + " puntos de vida");
    }

    public void mostrarMensajeExito(int vida){
        System.out.println("Orco: finaliza accion con exito" + "\nNueva vida: " + 
        vida);
    }

    public void mostrarMensajeDuerme(){
        System.out.println("Orco duerme");
    }
}