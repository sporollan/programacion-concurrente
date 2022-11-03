package tp6.ej1;
import java.util.concurrent.*;

public class Puente {
    private char dir;
    private int cruzaronCount = 0;
    private int limite = 4;
    private int direccionMax = 4;
    private int[] esperando = {0, 0};
    private Semaphore[] sems = {new Semaphore(limite), new Semaphore(0)};
    private Semaphore mutex = new Semaphore(1);
    public Puente(){
        this.dir = 0;
    }

    public void esperar(int direccionCoche){
        System.out.println("coche esperando");

        try{this.mutex.acquire();
            esperando[direccionCoche]++;
            this.mutex.release();
            this.sems[direccionCoche].acquire();
        } catch (InterruptedException e){};
    }

    public void cruzar(int direccionCoche){
        System.out.println("coche cruzando " + direccionCoche);
        try{
            Thread.sleep(3000);
            this.mutex.acquire();
        } catch (InterruptedException e){}
        this.cruzaronCount++;
        this.esperando[direccionCoche]--;
        this.mutex.release();
    }

    public void comprobarPaso(int direccionCoche){
        try{
            this.mutex.acquire();
        }  catch (InterruptedException e){};
        //System.out.printf("%d %d", this.esperando[0], this.esperando[1]);
        System.out.println(this.esperando[direccionCoche]);
        if(this.cruzaronCount==direccionMax || this.esperando[direccionCoche] == 0){
            this.cruzaronCount = 0;

            if (this.esperando[direccionCoche] < this.limite && this.esperando[direccionCoche] != 0){
                this.sems[this.dir].release(this.esperando[direccionCoche]);
            } else {
                if(this.dir == 0){
                    this.dir = 1;
                } else {
                    this.dir = 0;
                }
                if(this.esperando[this.dir] == 0){
                    if(this.dir == 0){
                        this.dir = 1;
                    } else {
                        this.dir = 0;
                    }     
                }
                this.sems[this.dir].release(limite);
            }
        } 
        this.mutex.release();
    }
}
