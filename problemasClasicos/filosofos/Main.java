package problemasClasicos.filosofos;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        int nFilosofos = 5;
        Thread[] filosofos = new Thread[nFilosofos];
        Semaphore[] semaforos = new Semaphore[nFilosofos];
        Semaphore currentSem, nextSem;
        Semaphore firstSem;
        currentSem = new Semaphore(1);
        firstSem = currentSem;
        for(int i = 0; i < nFilosofos; i++){
            nextSem = new Semaphore(1);
            filosofos[i] = new Thread(new Filosofo(i, currentSem, nextSem));
            filosofos[i].start();
            if(i == nFilosofos-2){
                currentSem = firstSem;
            } else {
                currentSem = nextSem;
            }

        }
    }
}
