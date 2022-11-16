package tp6.ej3;

public class Main {
    public static void main(String[] args){
        Observatorio o = new Observatorio();
        boolean silla;
        for(int i = 0; i < 100; i++){
            silla = (i == 45);
            Thread t = new Thread(new Visitante(o, ""+i, silla));
            t.start();
        }
        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new Mantenimiento(o, ""+i));
            t.start();
        }
        for(int i = 0; i < 3; i++){
            Thread t = new Thread(new Investigador(o, ""+i));
            t.start();
        }
    }
}
