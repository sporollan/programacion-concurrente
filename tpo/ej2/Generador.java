package tpo.ej2;

public class Generador implements Runnable{
    private Recipiente recipiente;

    public Generador(Recipiente recipiente){
        this.recipiente = recipiente;
    }
    public void run(){
        while(true){
            while(!this.recipiente.listo()){
                // el recipiente espera 2 hlisto y 1 olisto minimo
                this.recipiente.waitGenerador();
            }
            // luego genera agua
            System.out.println("generando agua");
            this.recipiente.hacerAgua();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){}

            // finalmente muestra el contenido y comprueba si debe vaciarse
            this.recipiente.show();
            this.recipiente.comprobarLleno();
        }

    }
}
