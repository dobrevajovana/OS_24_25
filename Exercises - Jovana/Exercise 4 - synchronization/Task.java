import java.util.concurrent.Semaphore;

public class Task {
    static final int BUFFER_SIZE = 20;
    static final int NUMPRODUCERS = 3;
    static final int NUMCONSUMERS = 2;
    static final int ITEMS_PER_PRODUCER = 10;

    //SEMAPHORES
    static final Semaphore empty = new Semaphore(BUFFER_SIZE);//20 empty keys
    static final Semaphore full = new Semaphore(0);//0 full keys
    static final Semaphore mutex = new Semaphore(1);//1 mutex key

    //buffer
    static int[] buffer = new int[BUFFER_SIZE];
    static int inindex = 0; // from where the producer continues
    static int outindex = 0; // from where the consumer continues

    public static void main(String[] args) {
        Thread[] producers = new Thread[NUMPRODUCERS];
        for(int i =0;i<NUMPRODUCERS;i++){
            producers[i] = new Thread(new Producer(i));
            producers[i].start();
        }
        Thread[] consumers = new Thread[NUMCONSUMERS];
        for(int i =0;i<NUMCONSUMERS;i++){
            consumers[i] = new Consumer(i);
            consumers[i].start();
        }

        for(Thread producer: producers){
            try {
                producer.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("All producers finished");
    }

    static class Producer implements Runnable{
        private int id;
        public Producer(int id){
            this.id = id;
        }

        @Override
        public void run() {
            for(int i =0;i<ITEMS_PER_PRODUCER;i++){
                try {
                    // empty --
                    empty.acquire();
                    // zkluci buffer
                    mutex.acquire();
                    // produce
                    buffer[inindex] = i;
                    System.out.println("Producer " + id + " produced: " + buffer[inindex]);
                    System.out.println("Buffer: " + buffer.length);
                    //19+1 % 20 = 0
                    inindex = (inindex + 1) % BUFFER_SIZE;
                    mutex.release();
                    // full++
                    full.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        
    }

    static class Consumer extends Thread{
        private int id;
        public Consumer(int id){
            this.id = id;
        }

        @Override
        public void run() {
            while(true){
                //full --
                try {
                    full.acquire();
                    //zakluci buffer

                    mutex.acquire();
                    //consume
                    int product = buffer[outindex];
                    System.out.println("Consumer " + id + " consumed: " + product);
                    //outindex++
                    System.out.println("Buffer: " + buffer.length);

                    outindex = (outindex + 1) % BUFFER_SIZE;
                    mutex.release();
                     //empty++
                    empty.release();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



               
            }
        }

        
    }


}
