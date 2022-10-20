package tp5.ej4;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Semaphore semTickets = new Semaphore(10);
        Semaphore semTren = new Semaphore(0);
        Semaphore semVendedor = new Semaphore(0);
        Semaphore semPasajero = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Tren tren = new Tren();
        Thread controlTren = new Thread(new ControlTren(tren, semTren, semTickets));
        controlTren.start();
        Thread vendedorTickets = new Thread(new VendedorTicket(tren, semVendedor, semTren, mutex));
        vendedorTickets.start();
        for(int i = 0; i < 100; i++){
            Thread pasajero = new Thread(new Pasajero("pasajero "+i, tren, mutex, semVendedor, semPasajero, semTickets));
            pasajero.start();
        }
    }
}
