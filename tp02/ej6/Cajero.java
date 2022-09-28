package tp02.ej6;

public class Cajero {
    private String nombre;
    public Cajero(String n){
        this.nombre = n;
    }
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + 
        cliente.getNombre() + " EN EL TIEMPO: " + 
        (System.currentTimeMillis() - timeStamp) / 1000 +
        "seg");
        
        for( int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
            "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
            1000 + "seg");
        }
        System.out.println("El cajero " + this.nombre + 
        " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
         (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    public void esperarXsegundos(int x){
        try{
            Thread.sleep(x * 1000);}
            catch(InterruptedException e){}
    }
}
