package tpo.ej3;

public class Main {
    public static void main(String[] args){
        Reloj reloj = new Reloj();
        Thread controladorReloj = new Thread(new ControladorReloj(reloj));
        controladorReloj.start();
        for(int i = 0; i<10; i++){
            Thread t = new Thread(new Trabajador(reloj, 9));
            t.start();
        }
    }
}
