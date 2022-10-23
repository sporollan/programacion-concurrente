package tpo.ej2;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        Recipiente recipiente = new Recipiente();
        Semaphore semHidrogeno = new Semaphore(0);
        Semaphore semOxigeno = new Semaphore(0);
        Thread generador = new Thread(new Generador(recipiente, semHidrogeno, semOxigeno));
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
