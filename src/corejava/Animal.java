package corejava;

public class Animal {
    private long age;

    public Animal(final long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }
}
