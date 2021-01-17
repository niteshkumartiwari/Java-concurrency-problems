package tryWithResource;

/*
Support for try-with-resources – introduced in Java 7 – allows us to declare resources to be used in a try block with the assurance that the resources will be closed when after the execution of that block.
The resources declared must implement the AutoCloseable interface.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
//        Scanner scanner=null;

        // Vanilla try-catch
//        try{
//            scanner= new Scanner(new File("D:\\Github\\Java-CP\\src\\tryWithResource\\test.txt"));
//            while (scanner.hasNext()){
//                System.out.println(scanner.nextLine());
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            if(scanner!=null)
//                scanner.close();
//        }

        try (Scanner scanner = new Scanner(new File("D:\\Github\\Java-CP\\src\\tryWithResource\\test.txt"));
             PrintWriter writer = new PrintWriter(new File("test.txt"))){
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
