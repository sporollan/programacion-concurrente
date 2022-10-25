package tpo.ej2;

import java.util.concurrent.Semaphore;

public class Recipiente {
    private int hlisto, olisto, agua;
    private Semaphore omutex, hmutex, amutex, olistoSem, hlistoSem;
    private Mon generadorMon;

    public Recipiente(Semaphore olistoSem, Semaphore hlistoSem){
        this.hlisto = 0;
        this.olisto = 0;
        this.agua = 0;
        this.omutex = new Semaphore(1);
        this.hmutex = new Semaphore(1);
        this.amutex = new Semaphore(1);
        this.generadorMon = new Mon();
        this.olistoSem = olistoSem;
        this.hlistoSem = hlistoSem;
    }

    public void waitGenerador(){
        this.generadorMon.w();
    }

    public void notifyGenerador(){
        this.generadorMon.n();
    }

    public void addHlisto(){
        System.out.println("add H");
        this.acq(this.hmutex);
        this.hlisto++;
        this.hmutex.release();
    }

    public void addOlisto(){
        System.out.println("add O");
        this.acq(this.omutex);
        this.olisto++;
        this.omutex.release();
    }

    public void acq(Semaphore s){
        try {
            s.acquire();
        } catch (InterruptedException e){}
    }

    public boolean listo(){
        boolean listo;

        this.acq(this.hmutex);
        listo = hlisto >= 2;
        this.hmutex.release();

        this.acq(this.omutex);
        listo = listo & olisto >=1;
        this.omutex.release();

        return listo;
    }

    public void hacerAgua(){
        this.acq(this.hmutex);
        this.hlisto-=2;
        this.hmutex.release();
        this.acq(this.omutex);
        this.olisto--;
        this.omutex.release();
        this.acq(this.amutex);
        this.agua++;
        this.amutex.release();
        this.hlistoSem.release(2);
        this.olistoSem.release();
    }

    public void show(){
        System.out.print("Agua: " + this.agua + " Olisto: " + this.olisto + " hlisto: " + this.hlisto + "\n");
    }

    public void comprobarLleno(){
        this.acq(this.amutex);
        if(this.agua >= 10){
            this.agua = 0;
            System.out.println("Vaciando recipiente");
        }
        this.amutex.release();

    }
}
