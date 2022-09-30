package tp03.ej2;

public class Main {
    public static void main(String[] args){
        Datos datos = new Datos();
        Curandero curandero = new Curandero(datos);
        Orco orco = new Orco(datos);
        orco.start();
        curandero.start();
        try {
            orco.join();
            curandero.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
