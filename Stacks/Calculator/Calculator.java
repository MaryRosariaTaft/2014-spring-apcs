import java.io.*;
import java.util.*;

public class Calculator{

    private  MyStackArrays<Double> stack=new MyStackArrays<Double>();

    public void calculate(){
    System.out.println("Calculate using postfix notation by entering numbers and the operators '+', '-', '*', and '/'.  To quit the program, just type 'quit' (actually, just type anything besides numbers and operators).");
	Scanner sc=new Scanner(System.in);
	boolean done=false;
	while(!done){
	    //System.out.println("Starting while loop");
	    if(sc.hasNextDouble()){
		stack.push(sc.nextDouble());
	    }else{
		String s=sc.next();
		if(!"+-*/".contains(s)){
		    System.out.println("Goodbye.");
		    break;
		}
		Double d1=0.0,d2=0.0;//Java compiler forces initialization
		try{
		    d1 = stack.pop();
		    //System.out.println("d1: "+d1);
		    d2 = stack.pop();
		    //System.out.println("d2: "+d2);
		}catch(EmptyStackException e){
		    System.out.println("Invalid input: operation requires two numerical values.  Closing program.");
		    break;
		}
		if(s.equals("+")){
		    System.out.println(d2+d1);
		    stack.push(d2+d1);
		}else if(s.equals("-")){
		    System.out.println(d2-d1);
		    stack.push(d2-d1);
		}else if(s.equals("*")){
		    System.out.println(d2*d1);
		    stack.push(d2*d1);
		}else if(s.equals("/")){
		    if(d1==0){
			throw new IllegalArgumentException("Cannot divide by 0.");
		    }
		    System.out.println(d2/d1);
		    stack.push(d2/d1);
		}
	    }
		System.out.println("Number of operations which can be made before the stack empties: "+(stack.size()-1));
	}
    }

}
