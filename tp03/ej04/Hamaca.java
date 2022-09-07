public class Hamaca {
    public Hamaca(){

    }
    public synchronized void hamacarse(int hamster, int delay) {
        System.out.println(hamster + " hamacandose");

        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){

        };
    }
}