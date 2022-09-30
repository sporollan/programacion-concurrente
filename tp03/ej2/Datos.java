package tp03.ej2;

public class Datos {
    private int vida = 10;
    private boolean flag;

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public synchronized boolean enUso(){
        if (!this.flag){
            this.flag = true;
        } else {
            return true;
        }
        return(!this.flag);
    }

    public void liberar(){
        this.flag = false;
    }
    
}
