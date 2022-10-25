package tpo.ej3;
import java.util.Random;

public class Reloj {
    private int tiempo, numTrabajador, despertados, horaAlarma, tiempoMax;
    private Despertador despertador;

    public Reloj(int numTrabajador){
        this.tiempo = 0;
        this.despertador = new Despertador();
        this.numTrabajador = numTrabajador;
        this.tiempoMax = 15;

        this.initHoraAlarmaRandom();
    }

    public void initHoraAlarmaRandom(){
        // permite asignar un numero aleatorio al valor alarma
        Random r = new Random();
        this.horaAlarma = r.nextInt(this.tiempoMax-2) + 1;
        System.out.println("Hora alarma: " + this.horaAlarma);
    }

    public boolean esHoraTrabajar(int horaT){
        return ((tiempo >= horaT) && (tiempo <= horaT+4));
    }

    public void dormir(int horaTrabajar){
        System.out.println("dormir " + Thread.currentThread().getName() + 
                            " trabaja entre " + horaTrabajar + 
                            " y " + (horaTrabajar+4));
        this.despertador.w();
    }

    public void despertar(){
        /*  utiliza el monitor despertador para despertar 1 trabajador
            se cuentan los despertados para utilizar en la funcion faltaDespertar*/
        this.despertador.n();
        this.despertados++;
    }

    public void resetDespertados(){
        this.despertados = 0;
    }

    public boolean faltaDespertar(){
        // comprueba si ya se desperto una vez a cada trabajador
        return(this.despertados != this.numTrabajador);
    }

    public void increase(){
        /*  se modifica el reloj y suena la alarma
            cada dia se establece un nuevo valor random
            para hora alarma */
        this.tiempo++;
        if(this.tiempo == this.tiempoMax){
            this.tiempo = 0;
            this.initHoraAlarmaRandom();
        }
        if(this.tiempo == this.horaAlarma){
            System.out.println("Sonando Alarma");
            this.despertar();
        }
        System.out.println(this.tiempo);
    }
}
