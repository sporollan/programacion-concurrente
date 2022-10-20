package tp5.ej4;
import java.util.concurrent.*;


public class VendedorTicket implements Runnable{
    private Semaphore semVendedor, semTren, mutex;
    private Tren tren;
    private int vendidos;
    public VendedorTicket(Tren tren, Semaphore semVendedor, Semaphore semTren, Semaphore mutex){
        this.tren = tren;
        this.semVendedor = semVendedor;
        this.semTren = semTren;
        this.vendidos = 0;
        this.mutex = mutex;
    }
    public void run(){
        while(true){
            try{
                semVendedor.acquire();
            } catch (InterruptedException e){
                System.out.println("semVendedor, vendedor ticket");
            }
            System.out.println("vendiendo ticket");
            this.venderTicket();
            this.mutex.release();
        }
    }

    public void venderTicket(){
        this.tren.registrarPasajero();
        vendidos++;
        if(vendidos==10){
            this.semTren.release();
            vendidos = 0;
        }
    }
}
