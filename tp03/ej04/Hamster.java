public class Hamster implements Runnable{
    private int num;
    private Rueda rueda;
    private Comedero comedero;
    private Hamaca hamaca;

    public Hamster(int num, Rueda rueda, Comedero comedero, Hamaca hamaca){
        this.num = num;
        this.rueda = rueda;
        this.comedero = comedero;
        this.hamaca = hamaca;
    }

    public void run(){
        this.rueda.correr(this.num, 1000);
        this.comedero.comer(this.num, 1000);
        this.hamaca.hamacarse(this.num, 1000);
    }

}
