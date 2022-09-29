package tp03.ej2;

public class Main {
    public static void main(String[] args){
        Vida vida = new Vida();
        Curandero c1 = new Curandero(vida);
        Orco o1 = new Orco(vida);
        c1.start();
        o1.start();
        try{
            c1.join();
            o1.join();
        } catch (InterruptedException e){
            System.out.println("exception");
        };
        System.out.println("Vida final es: " + vida.getVida());
    }
}
