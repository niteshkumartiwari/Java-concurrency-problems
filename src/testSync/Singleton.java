package testSync;

public class Singleton {

    private static Foo singleton=null;

    private Singleton() {
    }

    public static Foo getInstance() {
        if (singleton == null) {

            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Foo();
                    singleton.a = 10;
                }
            }
        }
        return singleton;
    }
}
