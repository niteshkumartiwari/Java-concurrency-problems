package unisexBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Driver {
    public static void main(String[] args) {
        UnisexBathroom unisexBathroom= new UnisexBathroom();
        AtomicInteger id= new AtomicInteger(0);

        ExecutorService executorService= Executors.newFixedThreadPool(100);

        //Add Males in bathroom
        for(int i=0;i<10;i++){
            executorService.submit(()-> unisexBathroom.maleUseBathRoom(String.valueOf(id.incrementAndGet())));
        }

        //Add Females in bathroom
        for(int i=0;i<10;i++){
            executorService.submit(()-> unisexBathroom.femaleUseBathRoom(String.valueOf(id.incrementAndGet())));
        }

        executorService.shutdown();
    }
}
