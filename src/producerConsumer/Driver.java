package producerConsumer;

public class Driver {
    public static void main(String[] args) throws Exception{
        BlockMeQueue<Integer> queue= new BlockMeQueue<>(10);

        //Producer
        final Runnable producer1=()->{
            int val=1;
            while(true){
                try {
                    queue.put(val);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                val +=1;

            }
        };

        final Runnable producer2=()->{
            int val=1;
            while(true){
                try {
                    queue.put(val);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                val -=1;
            }
        };

        new Thread(producer1).start();
        new Thread(producer2).start();

        final Runnable consumer1=()->{
            while(true){
                int val= 0;
                try {
                    val = queue.take();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("val from thread: "+Thread.currentThread() +" "+val);
            }
        };

        final Runnable consumer2=()->{
            while(true){
                int val= 0;
                try {
                    val = queue.take();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("val from thread: "+Thread.currentThread() +" "+val);
            }
        };

        new Thread(consumer1).start();
        new Thread(consumer2).start();

        Thread.sleep(1000);
    }
}
