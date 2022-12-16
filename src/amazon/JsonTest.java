package amazon;

public class JsonTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sleep Started");
        Thread.sleep(10000);
        System.out.println("Sleep Finished");
        Thread.currentThread().join();
        System.out.println("Completed");
    }
}
