package tp6.ej1;

public class Main {
    public static void main(String[] args){
        Puente puente = new Puente();
        for(int i = 0; i<10; i++){
            Thread coche = new Thread(new Coche(0, puente));
            coche.start();
        }
        for (int i = 0; i<20; i++){
            Thread coche = new Thread(new Coche(1, puente));
            coche.start();
        }
    }
}
