package tp5.ej4;

public class Tren {
    public String[] lugares;
    public int ultimo;
    public String nombre;
    public Tren(){
        lugares = new String[10];
        this.initLugares();
    }

    public void initLugares(){
        for(int i = 0; i<10; i++){
            this.lugares[i] = "";
        }
        this.ultimo = 0;
    }

    public void comprarTicket(String nombre){
        this.nombre = nombre;
    }

    public void registrarPasajero(){
        this.lugares[ultimo] = this.nombre;
        System.out.println("registrando " + this.nombre);
        ultimo++;
    }

    public void show(){
        for(int i = 0; i < lugares.length; i++){
            System.out.print(lugares[i] + " ");
        }
    }
}
