package tp5.ej2;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        int limite = 3;
        Semaphore perroSem = new Semaphore(limite);
        Semaphore gatoSem = new Semaphore(limite);
        Semaphore mutex = new Semaphore(1);
        Comedero comedero = new Comedero(limite);
        for(int i = 0; i<1000; i++){
            Thread gato = new Thread(new Animal("gato", gatoSem, perroSem, mutex, comedero), "gato"+i);
            gato.start();
        }
        for (int i = 0; i<100; i++){
            Thread perro = new Thread(new Animal("perro", gatoSem, perroSem, mutex, comedero), "perro"+i);
            perro.start();

        }
    }
    
}
