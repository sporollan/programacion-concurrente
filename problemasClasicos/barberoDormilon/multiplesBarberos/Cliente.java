package problemasClasicos.barberoDormilon.multiplesBarberos;

public class Cliente implements Runnable{
    private Peluqueria peluqueria;

    public Cliente(Peluqueria peluqueria){
        this.peluqueria = peluqueria;
    }
    
    public void run(){
        try{
        this.peluqueria.ingresar();
        } catch (InterruptedException e){};
    }
}
