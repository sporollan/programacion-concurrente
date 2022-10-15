package problemasClasicos.productorConsumidor;

public class Node {
    private Node next;
    private String producto;

    public Node(String producto){
        this.producto = producto;
        this.next = null;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public String getProducto(){
        return this.producto;
    }
}
