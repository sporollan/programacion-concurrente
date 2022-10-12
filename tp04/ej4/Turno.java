package tp04.ej4;

public class Turno {
    private int turno = 0;

    public synchronized boolean isTurno(int i){
        return (this.turno == i);
    }

    public int getTurno(){
        return this.turno;
    }

    public void increase(){
        this.turno++;
        if(this.turno == 3){
            this.turno = 0;
        }
    }
}
