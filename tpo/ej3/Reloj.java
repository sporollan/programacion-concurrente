package tpo.ej3;

public class Reloj {
    int tiempo;
    Despertador despertador;
    public Reloj(){
        this.tiempo = 0;
        this.despertador = new Despertador();
    }

    public boolean esHoraTrabajar(int horaT){
        return ((tiempo >= horaT) && (tiempo < horaT+4));
    }

    public void dormir(){
        System.out.println("dormir " + Thread.currentThread().getName());
        this.despertador.w();
    }

    public void despertar(){
        System.out.println("despertando " + Thread.currentThread().getName());
        this.despertador.n();
    }

    public synchronized void increase(){
        this.tiempo++;
        if(this.tiempo == 24)
            this.tiempo = 0;
        if(this.tiempo == 10){
            this.despertar();
            System.out.println("despertador");
        }
        System.out.println(this.tiempo);
    }
}
