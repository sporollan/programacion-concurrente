package tp03.ej3;

public class Main {
    // clase que simula la computadora central
    public static void main(String[] args){
        int n = 10;
        Thread[] terminales = new Thread[n];
        Sala sala = new Sala();
        for(int i = 0; i < n; i++){
            terminales[i] = new Thread(new Terminal(sala), Integer.toString(i));
            terminales[i].start();
        }
        for(int i = 0; i<n; i++){
            try{
                terminales[i].join();
            }catch(InterruptedException e){}
        }
        System.out.println("Sala final");
        System.out.println(sala.getSala());
    }
}
