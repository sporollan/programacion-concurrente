
public class Alquiler {
    private String cliente;
    private String fechaInicial;
    private String fechaFinal;
    private int posicionAmarre;
    private Barco barco;
    private int costoInicial = 200;

    public int calcularTiempo(){
        return this.fechaFinal-this.fechaInicial;
    }

    public int calcularValor(){
        int dias = this.calcularTiempo();
        return this.costoInicial + dias * this.eslora * 10;
    }
}