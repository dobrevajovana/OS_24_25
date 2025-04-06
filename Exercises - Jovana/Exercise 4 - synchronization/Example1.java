public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello from main thread: "+Thread.currentThread().getName());
        Counter counter = new Counter(0);
        for (int i = 0; i < 2; i++) {
            Thread thread = new BasicThread(counter);
            thread.start();
            thread.join();
            RunThread thread1 = new RunThread();
            thread1.run();
        }
    }

    public int program(){


        return 0;
    }
}

class Counter {
    private int counter;
    public Counter(int counter){
        this.counter = counter;
    }
    public synchronized void increment(){
        counter++;
        counter+=5;
    }
    public int getCounter(){
        return counter;
    }
}

class BasicThread extends Thread{
    //this is executed when the thread is started
    private Counter counter;
    int number = 0;
    String memory = "memory";   
    BasicThread(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        counter.increment();
        // Thread newthread = new BasicThread(counter);
        // newthread.start();
        System.out.println("Hello from thread: "+Thread.currentThread().getName()+" counter: "+counter.getCounter());
        System.out.println(number);
    }
}

class RunThread implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Hello from thread runnable: "+Thread.currentThread().getName());
    }

}