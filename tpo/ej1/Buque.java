package tpo.ej1;

public class Buque {
    int numAutos;
    public Buque(){
        numAutos = 0;
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

    public void ir(){
        System.out.println("Realizando viaje de ida con " + this.numAutos);
    }
    public void volver(){
        this.numAutos = 0;
        System.out.println("Realizando viaje de vuelta con " + this.numAutos);

    }

    public boolean isFull(){
        return this.numAutos == 10;
    }
}
