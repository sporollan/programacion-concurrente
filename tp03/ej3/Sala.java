package tp03.ej3;

public class Sala {
    private Asiento[] asientos;
    public Sala(){
        int s = 20;
        this.asientos = new Asiento[s];
        for(int i = 0; i < s; i++){
            this.asientos[i] = new Asiento(i);
        }
    }

    public void reservarAsiento(int n){
        asientos[n].reservar();
    }

    public String getTicket(int n){
        return this.asientos[n].getTicket();
    }

    public String getAsientosLibres(){
        String libres = "";
        for(int i = 0; i < asientos.length; i++){
            if(asientos[i].estaLibre()){
                libres += (Integer.toString(i) + " ");
            }
        }
        return libres;
    }

    public String getSala(){
        String sala = "";
        for(int i = 0; i < this.asientos.length; i++){
            sala += this.asientos[i].getReserva() + " ";
        }
        return sala;
    }

}
