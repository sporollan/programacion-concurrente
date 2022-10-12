package tp04.ej4;

public class Main {
    public static void main(String[] args){
        int numThreads = 3;
        Thread[] threads = new Thread[numThreads];
        char[] chars = {'A', 'B', 'C'};
        Turno turno = new Turno();
        for(int i = 0; i<numThreads; i++){
            threads[i] = new Thread(new Letra(i+2, chars[i], i, turno));
            threads[i].start();
        }

    }
}
