package tp03.ej2;

public class Vida {
    private int vida;

    public Vida(){
        this.vida = 10;
    }

    public void modificar(int v){
        this.vida += v;
    }

    public int getVida(){
        return this.vida;
    }

}
