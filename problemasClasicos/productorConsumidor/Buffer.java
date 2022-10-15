package problemasClasicos.productorConsumidor;

public class Buffer {
    private Node head, tail;
    public Buffer(){
        this.head = null;
        this.tail = null;
    }
    public void add(String producto){
        if(this.head == null){
            this.head = new Node(producto);
            this.tail = this.head;
        } else if (this.head == this.tail){
            this.head = new Node(producto);
            this.tail.setNext(head);
        } else {
            Node newNode = new Node(producto);
            this.head.setNext(newNode);
            this.head = newNode;
        }
    }
    public String pop(){
        String producto;
        if(this.tail == this.head){
            producto = this.tail.getProducto();
            this.tail = null;
            this.head = null;
        }
        else if(this.tail != null){
            producto = this.tail.getProducto();
            this.tail = this.tail.getNext();
        } else {
            producto = "";
        }
        return producto;
    }

    public void show(){
        String b ="";
        Node pointer = this.tail;
        while(pointer!=null){
            b += pointer.getProducto() + " ";
            pointer = pointer.getNext();
        }
        System.out.println(b);
    }
}
