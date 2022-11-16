package tp6.ej6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    private final ReentrantLock l = new ReentrantLock(true);
    private Condition camillaDisponible;
    private int camillasOcupadas;
    private int revistasDisponibles;

    public Sala(){
        this.camillaDisponible = l.newCondition();
        this.camillasOcupadas = 0;
        this.revistasDisponibles = 4;
    }

    public boolean hayLugar(){
        return camillasOcupadas < 5;
    }

    public boolean hayRevista(){
        return revistasDisponibles!=0;
    }
    public void ingresar(int n) throws InterruptedException{
        boolean revistaFlag = false;
        l.lock();
        while(!hayLugar()){
            if(hayRevista()){
                System.out.println(n + " leyendo revista");
                revistaFlag = true;
                revistasDisponibles--;
            } else if(!revistaFlag){
                //System.out.println(n + " mirando tele");
            }
            this.camillaDisponible.await();
        }
        camillasOcupadas++;
        if(revistaFlag){
            revistasDisponibles++;
            this.camillaDisponible.signal();
        }
        l.unlock();
        System.out.println(n + " usa camilla");
        Thread.sleep(10000);

        l.lock();
        camillasOcupadas--;
        this.camillaDisponible.signalAll();
        //show();

        l.unlock();

    }

    public void show(){
        System.out.printf("%d %d\n", camillasOcupadas, revistasDisponibles);
    }
}
