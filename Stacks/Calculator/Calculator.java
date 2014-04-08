import java.io.*;
import java.util.*;

public class Calculator{

    private static MyStackArrays<Double> stack = new MyStackArrays<Double>();

    public static void main(String[] args){
    System.out.println("Enter a postfix expression: ");
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()){
	    if(sc.hasNextDouble()){
		stack.push(sc.nextDouble());
	    }else{
		String s = sc.next();
		Double d1 = stack.pop(),
		    d2 = stack.pop();
		if(s.equals("+")){
		    stack.push(d1+d2);
		}else if(s.equals("-")){
		    stack.push(d1-d2);
		}else if(s.equals("*")){
		    stack.push(d1*d2);
		}else{//if(s.equals("/")){
		    stack.push(d1/d2);
		}
	    }

	}
	System.out.println(stack.pop());
    }

}
