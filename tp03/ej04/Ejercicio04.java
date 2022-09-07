

public class Ejercicio04{
    public static void main(String[] args){
        int numHamsters = 2000;
        Thread[] hamsters = new Thread[numHamsters];
        Rueda rueda = new Rueda();
        Comedero comedero = new Comedero();
        Hamaca hamaca = new Hamaca();
        for (int i = 0; i < numHamsters; i++){
            Hamster hamster = new Hamster(i, rueda, comedero, hamaca);
            hamsters[i] = new Thread(hamster);
            hamsters[i].start();
        }
    }
}