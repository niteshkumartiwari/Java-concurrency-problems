package test;

import java.util.*;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
//        Person p1= new Person("f1","l1");
//        Person p2= new Person("f2","l2");
//
//        Set<Person> set= new TreeSet<>();
//        set.add(null);
        Stream.of(1,2,3,4,5,6,7)
                .skip(5)
                .forEach(e-> System.out.println("num"+e));
    }
}
