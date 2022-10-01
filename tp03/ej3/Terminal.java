package tp03.ej3;
import java.util.Random;
public class Terminal implements Runnable{
    private Sala sala;
    public Terminal(Sala sala){
        this.sala = sala;
    }

    public void run(){
        Random r = new Random();
        String asientosLibres = " ";
        while(asientosLibres.length() != 0){
            System.out.println("Asientos libres:");
            asientosLibres = sala.getAsientosLibres();
            int numAsiento = r.nextInt(20);
            System.out.println(Thread.currentThread().getName() + " intenta reservar " + numAsiento);
            this.sala.reservarAsiento(numAsiento);
            System.out.println(this.sala.getTicket(numAsiento));
            try{
                Thread.sleep(1);
            } catch(InterruptedException e){};
        }

    }
}
