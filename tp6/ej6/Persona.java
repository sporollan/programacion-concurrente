package tp6.ej6;

public class Persona implements Runnable{
    private Sala s;
    private int n;

    public Persona(Sala s, int n){
        this.s = s;
        this.n = n;
    }
    public void run(){
        try{
            this.s.ingresar(n);
        } catch(InterruptedException e){};
    }
}
