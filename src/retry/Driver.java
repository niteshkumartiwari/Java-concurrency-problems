package retry;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Driver {
    public static void main(String[] args) throws MyException {
//        MyExceptionString[] grades = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
//
//        StringBuilder concat = Arrays.stream(grades)
//                .parallel()
//                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
//
//        System.out.println(concat.toString());
        Optional<Integer> value=Optional.of(1);

        value.ifPresent(val-> System.out.println(val));
//        valueList<Integer> integerList = Arrays.asList(1,2,3,4);
//        List<Integer> succeededList = Arrays.asList(45,46,47);
//
//        Optional<List<Integer>> optionalIntegers = Optional.ofNullable(integerList);
//        Optional.ofNullable(optionalIntegers).ifPresent(succeededList::addAll);
    }
}
