package printingOddEvenZero;

import java.util.concurrent.Semaphore;

public class Printer {
    private Semaphore oddSema = new Semaphore(0);
    private Semaphore evenSema= new Semaphore(0);
    private Semaphore zeroSema= new Semaphore(1);

    void printZero() throws InterruptedException {
        for(int i=1;i<20;i++){
            zeroSema.acquire();
            System.out.println(" 0 ");
            if(i % 2 == 0){
                evenSema.release();
            }else {
                oddSema.release();
            }
        }
    }

    void printEven() throws InterruptedException {
        for(int i=2;i<20;i+=2){
            evenSema.acquire();
            System.out.println(" "+ i+" ");
            zeroSema.release();
        }
    }

    void printOdd() throws InterruptedException {
        for(int i=1;i<20;i+=2){
            oddSema.acquire();
            System.out.println(" "+ i+" ");
            zeroSema.release();
        }
    }
}
