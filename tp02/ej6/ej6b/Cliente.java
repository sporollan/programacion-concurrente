package tp02.ej6.ej6b;

public class Cliente {
    private String nombre;
    private int[] carroCompra;
    
    public Cliente(String n, int[] c){
        this.nombre = n;
        this.carroCompra = c;
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public void setCarroCompra(int[] c){
        this.carroCompra = c;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int[] getCarroCompra(){
        return this.carroCompra;
    }

}
