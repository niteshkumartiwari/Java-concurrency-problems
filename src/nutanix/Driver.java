package nutanix;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        int[] arr= new int[1009];
        for(int i=0;i<1000;i++) arr[i]=i+1;

        Thread oddThread= new Thread(() -> {
           for(int i=0;i<1000;i+=2)
               System.out.println(arr[i]);
        });

        Thread evenThread= new Thread(()->{
           for(int i=1;i<1000;i+=2)
               System.out.println(arr[i]);
        });

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }
}
