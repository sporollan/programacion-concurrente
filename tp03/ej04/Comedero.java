public class Comedero {
    public Comedero(){

    }
    public synchronized void comer(int hamster, int delay) {
        System.out.println(hamster + " comiendo");
        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){

        };
    }
}