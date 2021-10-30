package bosch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parser {
    Map<String,String> map= new HashMap<>();

    private static Boolean parsingOperand(String param){//{k1 = v1}
        // handle = and !=
        /*
            s1 : fetch k1 and v1
            s2: check if = or !=
            s3 : return after evaluate
         */
    }

    public Boolean evaluate(String s){
        Stack<Integer> stack= new Stack<>();
        ExpressionBuilder builder= new ExpressionBuilder();

        for(int i=0;i<s.length();i++){//use while
            /*
                if ( push idx in stk
                else if ) :
                    s1= substr(idx, i) //[k1 = v1]
                    builder.addOperator(parsingOperand(s1))
                    if next exist
                        has to be oprand
                         builder.addOperand(s)
             */
        }

        Expression expression= builder.build();
        return expression.evaluate();// 1 AND 0 XOR 1
    }
}
