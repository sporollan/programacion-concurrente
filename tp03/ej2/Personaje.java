package tp03.ej2;

public class Personaje extends Thread {
    private Datos datos;
    public Personaje(Datos datos){
        this.datos = datos;
    }

    public int getValorP(){
        return 3;
    }

    public void mostrarMensajeAccion(){

    }

    public void mostrarMensajeExito(int vida){

    }

    public void mostrarMensajeDuerme(){};

    public void accion(){
        int p = getValorP();
        if(!datos.enUso()){
            int vida = datos.getVida();
            this.mostrarMensajeAccion();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            datos.setVida(vida+p);
            this.mostrarMensajeExito(datos.getVida());
            datos.liberar();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.mostrarMensajeDuerme();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOver(){
        return (this.datos.getVida() <= 0);
    }

    public void run(){
        while (!this.isOver()){
            this.accion();
        }
    }
}
