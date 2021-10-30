package kachra;

import java.util.*;
import java.util.stream.Collectors;

public class Driver {
    public static Optional<Integer> foo(){
        Integer a=null;

        if(a==null) return Optional.empty();

        return Optional.ofNullable(null);
    }
    public static void main(String[] args) {
//        Set<Integer> integerSet= new HashSet<>();
//        Set<Integer> whiteList = new HashSet<>();
//
//        for(int i=1;i<=1000;i++){
//            integerSet.add(i);
//        }
//        for(int i=1;i<=100;i++){
//            int num =  (int) (Math.random()*1000.0) + 1;
//            whiteList.add(num);
//        }
//
//        List<Integer> vals= integerSet.stream()
//                                        .filter(e -> whiteList.contains(e))
//                                        .limit(10)
//                                        .collect(Collectors.toList());
//        System.out.println("WhiteList: ");
//        for(Integer i : whiteList){
//            System.out.print(i +" ");
//        }
//
//        System.out.println("\n Output: ");
//        for(Integer i : vals){
//            System.out.print(i +" ");
//        }
//i
//        Optional<Listing> npsListing = Optional.ofNullable(   null);
//
//        Set<ValueTag> valueTag= npsListing
//                .flatMap(e -> Optional.ofNullable(e.getPnpLiteListingInfo()))
//                .flatMap(e-> Optional.ofNullable(e.getValueTag()))
//                .orElse(null);
//
//        System.out.println(valueTag);
//        Set<Integer> set= new LinkedHashSet<>();
//        List<Integer> l1 = Arrays.asList(1,1,2,3,5,6,9,9,9);
//        List<Integer> l2 = Arrays.asList(1,8,9);
//        List<Integer> l3 = Arrays.asList(1,4,5,10);
//
//        List<Integer> la= new ArrayList<>();
//        la.addAll(l1);
//        la.addAll(l2);
//        la.addAll(l3);
//
//        System.out.println(new LinkedHashSet<>(la));
//        List<ValueTag> valueTags= new ArrayList<>();
//        Set<Integer> integerSet= new HashSet<>();
//        valueTags
//        valueTags.addAll(Driver.foo());
//
//
//        System.out.println(valueTags);
//
//        System.out.println(Boolean.TRUE.equals(true));
//
//        System.out.println(foo().orElse(null));

//        List<Meta> list= new ArrayList<>();
//        list.add(new Meta(Long.valueOf(1)));
//        list.add(new Meta(Long.valueOf(2)));
//        list.add(new Meta(Long.valueOf(3)));
//        list.add(new Meta(Long.valueOf(4)));
//        list.add(new Meta(Long.valueOf(5)));
//
//        Meta meta=list.stream().min(Comparator.comparingLong(Meta::getVal)).get();
//
//        System.out.println(meta.val);

//        B b= new B();
//        b.

        B<Long> tmp= new B<>();
        System.out.println(tmp.invoke());

    }
}
