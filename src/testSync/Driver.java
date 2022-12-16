package testSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for(int i=0;i<100000;i++){
            executor.submit(()-> {
                Singleton.getInstance().getValue();
            });
        }
        Thread.sleep(1000);

        System.out.println("val: "+ Singleton.getInstance());
    }
}
