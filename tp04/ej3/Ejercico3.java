import java.util.concurrent.Semaphore;

public class Ejercico3 {
    public static void main(String[] args){
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);

        P p1r = new P(sem1, sem2, 1);


        Thread p1 = new Thread(p1r);
        Thread p2 = new Thread(new P(sem2, sem3, 2));
        Thread p3 = new Thread(new P(sem3, sem1, 3));

        p1.start();
        p2.start();
        p3.start();
    }

}
