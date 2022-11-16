package tp6.ej3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private final ReentrantLock r = new ReentrantLock();
    private Condition vCond, mCond, iCond;
    private boolean vEsperar, mFlag, iFlag;
    private int visitantes, visitaron, mantenimiento, investigadores, capacidad, numSilla;
    public Observatorio(){
        this.mFlag = false;
        this.iFlag = false;
        this.vEsperar = false;
        this.vCond = r.newCondition();
        this.mCond = r.newCondition();
        this.iCond = r.newCondition();
        this.visitantes = 0;
        this.visitaron = 0;
        this.mantenimiento = 0;
        this.investigadores = 0;
        this.capacidad = 50;
        this.numSilla = 0;
    }

    public boolean hayLugar(Boolean silla){
        boolean hay;
        if(silla){
            this.capacidad = 30;
            hay = this.visitantes < 30;
        } else {
            hay = this.visitantes < this.capacidad;
        }
        return hay;
    }

    public void visitar(String n, boolean silla) throws InterruptedException{
        // no hay mantenimiento ni cientificos
        this.r.lock();
        while(!hayLugar(silla) || hayMantenimiento() || hayInvestigador() || mFlag || iFlag || vEsperar){
            this.vCond.await();
        }
        if(silla){
            this.numSilla++;
        }
        this.visitantes++;
        this.vCond.signalAll();
        this.r.unlock();

        System.out.println(n + " visita");
        Thread.sleep(1000);

        this.r.lock();
        //this.show();
        this.numSilla--;
        if(this.numSilla == 0)
            this.capacidad = 50;
        this.visitantes--;
        this.visitaron++;

        if(this.visitaron > 70){
            vEsperar = true;
            this.visitaron = 0;
        }
        this.mCond.signal();
        this.iCond.signal();
        this.r.unlock();
    }

    public void mantener(String n) throws InterruptedException{
        // no hay visitantes ni investigadores
        this.r.lock();
        this.mFlag = true;
        while(hayVisitante() || hayInvestigador() || iFlag){
            this.mCond.await();
        }
        this.mantenimiento++;
        this.mCond.signalAll();

        this.r.unlock();

        System.out.println(n + " mantiene");
        Thread.sleep(1000);

        this.r.lock();
        //this.show();

        this.mantenimiento--;

        if(this.mantenimiento == 0)
            this.mFlag = false;
        this.vCond.signal();
        this.iCond.signal();

        this.r.unlock();


    }

    public void investigar(String n)throws InterruptedException{
        // no hay visitantes ni mantenimiento
        this.r.lock();
        this.iFlag = true;
        while(hayVisitante() || hayMantenimiento()){
            this.iCond.await();
        }
        this.investigadores++;
        this.iCond.signalAll();

        this.r.unlock();

        System.out.println(n + " investiga");
        Thread.sleep(1000);

        this.r.lock();
        //this.show();
        this.investigadores--;
        if(this.investigadores == 0)
            this.iFlag = false;
        this.vCond.signal();
        this.mCond.signal();
        this.r.unlock();
    }

    public boolean hayVisitante(){
        return visitantes!=0;
    }

    public boolean hayMantenimiento(){
        return mantenimiento!=0;
    }

    public boolean hayInvestigador(){
        return investigadores!=0;
    }

    public void show(){
        System.out.printf("%d %d %d\n", visitantes, mantenimiento, investigadores);
    }
}
