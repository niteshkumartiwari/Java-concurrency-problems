package fk;

import java.util.function.Supplier;

public class Driver {
    public static Meow catSound(){
        return new Meow("Black");
    }

    public static void main(String[] args) {
//        IAnimal<Meow> cat= new IAnimal<Meow>() {
//            @Override
//            public <Meow> Meow apply() {
//               return (Meow) catSound();
//            }
//        };

        IAnimal cat= ()-> catSound();
    }

}
