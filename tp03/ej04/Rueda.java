public class Rueda {
    public Rueda(){

    }
    public synchronized void correr(int hamster, int delay) {
        System.out.println(hamster + " corriendo");

        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){

        };
    }
}
