package tp04.ej4;

public class Letra implements Runnable{
    private int veces;
    private char letra;
    private int turno;
    private Turno turnoActual;

    public Letra(int veces, char letra, int turno, Turno turnoActual){
        this.veces = veces;
        this.letra = letra;
        this.turno = turno;
        this.turnoActual = turnoActual;
    }

    public void run(){
        while(true){
            if(this.turnoActual.isTurno(this.turno)){
                for(int i = 0; i<veces; i++){
                    System.out.print(this.letra);
                }
                this.turnoActual.increase();
            }
        }
    }
    
}
