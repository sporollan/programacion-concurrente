public class Dato {
    private int suma;
    public Dato(){
        suma = 0;
    }

    public int getDato(){
        return suma;
    }

    public synchronized void incrementar(int s){
        suma += s;
    }
}
