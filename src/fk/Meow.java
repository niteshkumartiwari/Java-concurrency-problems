package fk;

public class Meow {
    private String color;

    Meow(String color){
        this.color= color;
    }

    @Override
    public String toString() {
        return "Meow{" +
                "color='" + color + '\'' +
                '}';
    }
}
