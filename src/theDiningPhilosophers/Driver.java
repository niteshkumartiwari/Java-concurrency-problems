package theDiningPhilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        final int NUMBER_OF_PHILOSOPHERS = 4;
        Philosopher[] philosophers= new Philosopher[NUMBER_OF_PHILOSOPHERS];
        Object[] forks= new Object[philosophers.length];

        for(int i=0;i<forks.length;i++){
            forks[i]= new Object();
        }

        ExecutorService philosopherService= Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);

        for(int i=0;i<philosophers.length;i++){
            Object leftFork= forks[i];
            Object rightFork= forks[(i+1) % forks.length];

            if(i == philosophers.length-1){
                philosophers[i]= new Philosopher(rightFork,leftFork);
            }else{
                philosophers[i]= new Philosopher(leftFork,rightFork);
            }

//            philosophers[i]= new Philosopher(leftFork,rightFork); //results in deadlock
            Thread t= new Thread(philosophers[i]);
            philosopherService.execute(t);
        }
    }
}
