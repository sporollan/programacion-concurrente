package tp03.ej1;
import java.util.logging.*;
public class VerificarCuenta implements Runnable{
    private CuentaBanco cb = new CuentaBanco();

    private synchronized void HacerRetiro(int cantidad)throws InterruptedException{

        if (cb.getBalance() >= cantidad){
            System.out.println( Thread.currentThread().getName() + 
            "esta realizando un retiro de: " + cantidad + ".");
            Thread.sleep(1000);
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() + 
            ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " +
            cb.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr." +
            Thread.currentThread().getName());
            System.out.println("Su saldo actual es de" + cb.getBalance());
            Thread.sleep(1000);
        };
    }

    public void run(){
        for(int i = 0; i<= 3; i++){
            try{
                this.HacerRetiro(10);
                if(cb.getBalance() < 0){
                    System.out.println("La cuenta esta sobregirada");
                }
            } catch (InterruptedException ex){
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
