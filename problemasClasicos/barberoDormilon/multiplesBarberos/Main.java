package problemasClasicos.barberoDormilon.multiplesBarberos;

public class Main {
    public static void main(String[] args){
        Peluqueria peluqueria = new Peluqueria();
        for(int i = 0; i<100; i++){
            Thread cliente = new Thread(new Cliente(peluqueria));
            cliente.start();
        }
        for(int i = 0; i<3; i++){
            Thread barbero = new Thread(new Barbero(peluqueria));
            barbero.start();
        }
    }
}
