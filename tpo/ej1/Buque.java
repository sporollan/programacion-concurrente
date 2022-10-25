package tpo.ej1;

public class Buque {
    private int numAutos;
    private Mon barreraMon, controlMon;
    //private Mon2 controlMon;
    public Buque(){
        this.numAutos = 0;
        this.barreraMon = new Mon();
        this.controlMon = new Mon();
    }

    public synchronized void w(){
        try{
            this.wait();
        } catch (InterruptedException e){}
        finally {}
    }

    public synchronized void n(){
        this.notify();
    }

    public void addAuto(){
        this.numAutos++;
    }

    public void rmAuto(){
        this.numAutos--;
    }

    public void waitControl(){
        this.controlMon.w();
    }

    public void notifyControl(){
        this.controlMon.n();
    }

    public void waitBarrera(){
        this.barreraMon.w();
    }

    public void notifyBarrera(){
        this.barreraMon.n();
    }

    public void ir(){
        System.out.println("Realizando viaje de ida con " + this.numAutos);
    }
    public void volver(){
        System.out.println("Realizando viaje de vuelta con " + this.numAutos);

    }

    public boolean isFull(){
        return this.numAutos == 10;
    }

    public boolean isEmpty(){
        return this.numAutos == 0;
    }
}
