package problemasClasicos.barberoDormilon.multiplesBarberos;

public class Barbero implements Runnable {
    private Peluqueria peluqueria;
    public Barbero(Peluqueria peluqueria){
        this.peluqueria = peluqueria;
    }
    public void run(){
        while(true){
            try{
            this.peluqueria.cortar();
            } catch (InterruptedException e){}
        }
    }
}
