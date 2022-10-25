package tpo.ej2;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Semaphore semHidrogeno = new Semaphore(0);
        Semaphore semOxigeno = new Semaphore(0);
        Recipiente recipiente = new Recipiente(semOxigeno, semHidrogeno);

        Thread generador = new Thread(new Generador(recipiente));
        generador.start();
        for(int i = 0; i < 40; i++){
            Thread hidrogeno = new Thread(new Hidrogeno(recipiente, semHidrogeno));
            hidrogeno.start();
        }
        for(int i = 0; i < 20; i++){
            Thread oxigeno = new Thread(new Oxigeno(recipiente, semOxigeno));
            oxigeno.start();
        }
        
    }
}
