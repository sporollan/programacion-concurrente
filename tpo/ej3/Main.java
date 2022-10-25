package tpo.ej3;

public class Main {
    public static void main(String[] args){
        int numTrabajador = 5;
        Reloj reloj = new Reloj(numTrabajador);
        Thread controladorReloj = new Thread(new ControladorReloj(reloj), "reloj");
        controladorReloj.start();
        for(int i = 0; i<numTrabajador; i++){
            Thread t = new Thread(new Trabajador(reloj, i), "trabajador "+i);
            t.start();
        }
    }
}
