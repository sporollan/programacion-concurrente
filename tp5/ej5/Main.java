package tp5.ej5;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Semaphore avionSem = new Semaphore(0);
        Semaphore pistaSem = new Semaphore(0);
        Semaphore torreSem = new Semaphore(0);
        Pista pista = new Pista();
        Thread torre = new Thread(new Torre(torreSem, avionSem, pistaSem));
        torre.start();
        for(int i = 0; i<10; i++){
            Thread avion = new Thread(new Avion(pista, torreSem, avionSem, pistaSem), "avion "+i);
            avion.start();
        }
    }
}
