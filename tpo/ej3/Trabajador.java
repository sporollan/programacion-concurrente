package tpo.ej3;

public class Trabajador implements Runnable{
    private Reloj reloj;
    private int horaTrabajar;
    public Trabajador(Reloj reloj, int horaTrabajar){
        this.reloj = reloj;
        this.horaTrabajar = horaTrabajar;
    }

    public void trabajar(){
        System.out.println("trabajando " + Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){}
    }
    public void run(){
        this.reloj.dormir();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){}
        this.reloj.despertar();
        System.out.println(Thread.currentThread().getName());
        while(true){
            while(!this.reloj.esHoraTrabajar(horaTrabajar)){
                this.reloj.dormir();
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){}
                this.reloj.despertar();
            }
            this.trabajar();
        }
    }
}
