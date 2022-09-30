package tp03.ej2;

public class Orco extends Thread{
    private Datos datos;
    public Orco(Datos datos){
        this.datos = datos;
    }

    public void accion(){
        int p = 5;
        if(!datos.enUso()){
            int vida = datos.getVida();
            System.out.println("Orco: quitando " + p + " puntos de vida");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            datos.setVida(vida-p);
            System.out.println("Orco: finaliza accion con exito" + "\nNueva vida: " + 
                                datos.getVida());
            datos.liberar();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Orco duerme");
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