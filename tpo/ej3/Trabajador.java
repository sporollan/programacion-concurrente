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
        System.out.println("termina de trabajar " + Thread.currentThread().getName());
    }
    public void run(){

        while(true){
            do{
                /*  inicia durmiendo. Luego se despierta, despierta al proximo
                    trabajador  y comprueba si es su hora de trabajar. 
                    Mientras no lo sea vuelve a dormir. */
                this.reloj.dormir(this.horaTrabajar);
                System.out.println("Despertandose " + Thread.currentThread().getName()+ 
                " trabaja entre " + horaTrabajar + 
                " y " + (horaTrabajar+4));
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){}
                if(this.reloj.faltaDespertar())
                    // esto permite que cada trabajador se despierte una vez por turno.
                    this.reloj.despertar();
                else 
                    this.reloj.resetDespertados();
            } while (!this.reloj.esHoraTrabajar(horaTrabajar));

            // si es su hora de trabajar, trabaja y vuelve a comenzar el ciclo.
            this.trabajar();
        }
    }
}
