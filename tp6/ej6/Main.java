package tp6.ej6;

public class Main {
    public static void main(String[] args){
        Sala s = new Sala();
        for(int i = 0; i < 100; i++){
            Thread p = new Thread(new Persona(s, i));
            p.start();
        }
    }
}
