package tp03.ej3;
public class Asiento {
    private boolean reservado;
    private String reserva;
    private int numAsiento;

    public Asiento(int n){
        this.reservado = false;
        this.numAsiento = n;
        this.reserva = "";
    }

    public synchronized void reservar(){
        if(this.reservado){
            System.out.println("Error, el asiento " + this.numAsiento + 
            " ya esta reservado por " + this.reserva);
        } else {
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){};
            System.out.println(Thread.currentThread().getName() + 
            " reservando " + this.numAsiento);
            this.reservado = true;
            reserva += Thread.currentThread().getName();
        }
    }

    public String getTicket(){
        return "Asiento " + this.numAsiento + " reservado por " + this.reserva;
    }

    public boolean estaLibre(){
        return !this.reservado;
    }

    public String getReserva(){
        return this.reserva;
    }
}