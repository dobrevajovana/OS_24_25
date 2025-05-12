import java.util.Random;
import java.util.concurrent.Semaphore;

public class example2{

    public static void main(String[] args) {
    int[][] matrix = new int[5][5];
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            matrix[i][j] = random.nextInt(100);  // Random numbers from 0 to 99
            System.out.print(matrix[i][j] + "\t");
        }
        System.out.println();
    }
    int[] list = new int[5];
    for (int i =0;i<5;i++){
        int[] row = matrix[i];
        MaxThread maxThread = new MaxThread(row);
        maxThread.start();
        int max = maxThread.getMax();
        list[i] = max;

    }
    for()
    for(Thread thread: Thread.getAllStackTraces().keySet()){
        if(thread instanceof MaxThread){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    System.out.println("Max: " + max);

}

static class MaxThread extends Thread{
    int[] row;
    int max;
    public MaxThread(int[] row) {
        this.row = row;
        this.max = 0;
    }
    @Override
    public void run() {
        for(int i: row){
                if(i > max){
                    max = i;
                }
            }
        }
    
    public int getMax(){
        return max;
    }
    public int[] getRow() {
        return row;
    }
    public void setRow(int[] row) {
        this.row = row;
    }
    public void setMax(int max) {
        this.max = max;
    }
            
}
}