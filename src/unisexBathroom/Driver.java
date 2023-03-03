package unisexBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        UnisexBathroom unisexBathroom= new UnisexBathroom();
        AtomicInteger id= new AtomicInteger(0);

        ExecutorService executorService= Executors.newFixedThreadPool(100);

        executorService.submit(()-> unisexBathroom.maleUseBathRoom(String.valueOf(id.incrementAndGet())));
        Thread.sleep(100);
        executorService.submit(()-> unisexBathroom.maleUseBathRoom(String.valueOf(id.incrementAndGet())));
        executorService.submit(()-> unisexBathroom.femaleUseBathRoom(String.valueOf(id.incrementAndGet())));
        Thread.sleep(450);
        executorService.submit(()-> unisexBathroom.maleUseBathRoom(String.valueOf(id.incrementAndGet())));


        executorService.shutdown();
    }
}
