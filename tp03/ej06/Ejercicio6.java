import java.util.Random;

public class Ejercicio6 {
    public static void main(String[] args){
        Random rand = new Random();
        int numElementos = 50000;
        int[] arr = new int[numElementos];
        int numHilos = 7;
        int sumSecuencial = 0;
        int cantPorHilo;
        int rm;
        for(int i = 0; i<numElementos; i++){
            arr[i] = rand.nextInt(10);
            sumSecuencial += arr[i];
        }
        System.out.print("Suma secuencial: ");
        System.out.println(sumSecuencial);
        cantPorHilo = numElementos / numHilos;

        int bloquesInicio = 0;
        int bloquesFinal = cantPorHilo;
        Dato unD = new Dato();
        Thread[] t = new Thread[numHilos]; 
        for(int i = 0; i < numHilos-1; i++){
            
            Hilo p1 = new Hilo(unD, bloquesInicio, bloquesFinal, arr);

            Thread h1 = new Thread(p1);
            t[i] = h1;
            h1.start();


            bloquesInicio += cantPorHilo;
            bloquesFinal += cantPorHilo;
        }

        Hilo p1 = new Hilo(unD, bloquesInicio, numElementos, arr);
        Thread h1 = new Thread(p1);
        t[numHilos-1] = h1;
        h1.start();

        for(int i = 0; i < numHilos; i++){
            try {
                t[i].join();       
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.out.print("Suma concurrente: ");
        System.out.println(unD.getDato());








        
    }
}