package tpo.ej2;

public class Recipiente {
    public int hlisto, olisto, agua;
    public Recipiente(){
        this.hlisto = 0;
        this.olisto = 0;
        this.agua = 0;
    }

    public void addHlisto(){
        System.out.println("add H");
        this.hlisto++;
    }

    public void addOlisto(){
        System.out.println("add O");
        this.olisto++;
    }


    public void hacerAgua(){
        this.hlisto-=2;
        this.olisto--;
        this.agua++;
    }

    public void show(){
        System.out.print("Agua: " + this.agua + " Olisto: " + this.olisto + " hlisto: " + this.hlisto + "\n");
    }

    public void vaciar(){
        this.agua = 0;
    }

    public void comprobarLleno(){
        if(this.agua == 10){
            this.vaciar();
            System.out.println("Vaciando recipiente");
        }
    }
}
