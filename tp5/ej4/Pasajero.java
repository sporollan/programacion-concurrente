package tp5.ej4;
import java.util.concurrent.*;

public class Pasajero implements Runnable{
    private Tren tren;
    private Semaphore mutex, semVendedor, semPasajero, semTickets;
    private String nombre;

    public Pasajero(String nombre, Tren tren, Semaphore mutex, Semaphore semVendedor, Semaphore semPasajero, Semaphore semTickets){
        this.nombre = nombre;
        this.tren = tren;
        this.semVendedor = semVendedor;
        this.mutex = mutex;
        this.semPasajero = semPasajero;
        this.semTickets = semTickets;
    }

    public void run(){
        Boolean ticketComprado = false;
        while(!ticketComprado){
            if(semTickets.tryAcquire()){
                try{
                    mutex.acquire();
                } catch (InterruptedException e){
                    System.out.println("mutex");
                }
                this.tren.comprarTicket(this.nombre);
                semVendedor.release();
                ticketComprado = true;
                try{
                    //semPasajero.acquire();
                    Thread.sleep(1);
                } catch(InterruptedException e){}
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("esperando");
            }
        }

    }
}
