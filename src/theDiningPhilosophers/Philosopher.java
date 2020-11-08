package theDiningPhilosophers;

public class Philosopher implements Runnable{
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try{
            //thinking
            while (true){
                doAction(System.nanoTime()+": Thinking");
                synchronized (leftFork){
                    doAction(System.nanoTime()+": Picked-up left fork");
                    synchronized (rightFork){
                        doAction(System.nanoTime()+": Picked-up right fork");

                        //eating
                        Thread.sleep(100);


                        doAction(System.nanoTime()+" Put-down right fork");
                    }

                    doAction(System.nanoTime()+" Put-down left fork. Back to thinking...");
                }
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void doAction(String action){
        System.out.println(Thread.currentThread().getName()+ " "+ action);
        try {
            Thread.sleep((int)Math.random()*100);
        } catch (InterruptedException e) {
            System.out.println("Error while sleeping");
            e.printStackTrace();
        }
    }
}
