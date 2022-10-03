package tp04.ej6;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(0);
        Thread mozo = new Thread(new Mozo(sem1, sem2));
        Thread empleado = new Thread(new Empleado(sem2, sem1));
        mozo.start();
        empleado.start();
    }
}
