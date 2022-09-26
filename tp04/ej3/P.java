import java.util.concurrent.Semaphore;

public class P implements Runnable{
    private Semaphore sem;
    private Semaphore nextSem;
    private int n;
    public P(Semaphore sem, Semaphore nextSem, int n){
        this.sem = sem;
        this.nextSem = nextSem;
        this.n = n;
    }
    public void run(){
        while (true){
            try{
                this.sem.acquire();
            } catch(InterruptedException e){};
            System.out.println("Acquire " + this.n);
            try{Thread.sleep(1000);
            } catch(InterruptedException e){};
            this.nextSem.release();
        }
    }
}
