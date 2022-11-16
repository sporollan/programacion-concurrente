package tp6.ej3;
public class Visitante implements Runnable{
    private Observatorio o;
    private String n;
    private boolean silla;

    public Visitante(Observatorio o, String n, boolean silla){
        this.o = o;
        this.n = n;
        this.silla = silla;
    }
    public void run(){
        try{
            this.o.visitar(n, silla);
        } catch (InterruptedException e){}
    }
    
}
