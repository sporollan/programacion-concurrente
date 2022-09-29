package tp03.ej2;

public class Vida {
    private int vida;

    public Vida(){
        this.vida = 10;
    }

    public synchronized boolean modificar(int v){
        boolean f = false;
        if(this.vida > 0){
            this.vida += v;
            f = true;
        }
        return f;
    }

    public int getVida(){
        return this.vida;
    }

}
