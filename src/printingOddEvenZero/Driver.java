package printingOddEvenZero;

import unisexBathroom.UnisexBathroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) throws Exception{
        Printer printer= new Printer();

        ExecutorService executorService= Executors.newFixedThreadPool(100);

        executorService.submit(()-> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                printer.printZero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()-> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        executorService.shutdown();
    }
}
