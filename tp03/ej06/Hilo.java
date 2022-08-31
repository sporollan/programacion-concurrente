public class Hilo implements Runnable{
    private Dato unD;
    private int bi;
    private int bf;
    private int[] arr;

    public Hilo(Dato unD, int bi, int bf, int[] arr){
        this.unD = unD;
        this.bi = bi;
        this.bf = bf;
        this.arr = arr;
    }
    public void run() {
        int sum = 0;
        for(int i = this.bi; i < this.bf; i++){
            sum += this.arr[i];
        }
        unD.incrementar(sum);
    }
    
}
