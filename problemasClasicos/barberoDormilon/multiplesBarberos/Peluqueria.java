package problemasClasicos.barberoDormilon.multiplesBarberos;
import java.util.concurrent.*;

public class Peluqueria {
    private Semaphore semClienteEsperando = new Semaphore(3);
    private Semaphore semBarberoCortar = new Semaphore(0);
    private int sillasEspera = 5;
    private int esperando = 0;
    
    public void semClienteEsperandoAcq() throws InterruptedException{
        this.semClienteEsperando.acquire();
    }

    public void semClienteEsperandoRelease(){
        this.semClienteEsperando.release();
    }

    public boolean hayLugar(){
        return (esperando <= sillasEspera);
    }

    public void ingresar() throws InterruptedException{
        boolean realizoCorte = false;
        while(this.hayLugar() && !realizoCorte){
            semClienteEsperando.acquire();
            semBarberoCortar.release();
            System.out.println("Cliente cortandose el pelo");
            synchronized(this){
            this.wait();
            }
            semClienteEsperando.release();
        }
    }

    public void cortar() throws InterruptedException{
        semBarberoCortar.acquire();
        System.out.println("Barbero cortando pelo");
        Thread.sleep(3000);
        synchronized(this){
        this.notify();
        }
    }
}
