package cp;

import java.io.ObjectStreamClass;
import java.util.*;

class Driver{
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j==1) break;
                System.out.println("i: "+i+" j: "+j);
            }
        }
    }
}