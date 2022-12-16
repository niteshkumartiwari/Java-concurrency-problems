package retry;

public class Utils {
    static int baseInMs = 200;
    static int randomInMs = 100;
    static int maxRetry=4;

    public static int foo() throws MyException {
        for(int i=0;i<maxRetry;i++){
            System.out.println(i+": iteration started");
            try{
                return bar(i);
            } catch (MyException e) {
                int waitIntervalInMs = (baseInMs)*(int)Math.pow(2,i) + getRandomJitter();
                try {
                    System.out.println("Starting wait for :"+waitIntervalInMs);
                    Thread.sleep(waitIntervalInMs);
                } catch (InterruptedException ex) {
                    throw new MyException("Interrupted exception occured during thread wait");
                }
            }
        }

        throw new MyException("Retry exhausted");
    }

    private static int getRandomJitter(){
        int random=(int)(Math.random()*2);
        return (random == 0) ? randomInMs : -randomInMs;
    }

    private static int bar(int value) throws MyException {
        if(value==5){
            return 500;
        }

        throw new MyException("not 5!");
    }
}
