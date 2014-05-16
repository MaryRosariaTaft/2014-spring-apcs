import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	Random rand=new Random();
	RunningMedian rm=new RunningMedian();

	//put values in heaps
	for(int i=0;i<10;i++){
	    rm.add(rand.nextInt(20));
	}

	//print out arrays
	int[] max=rm.getMax();
	int[] min=rm.getMin();
	System.out.println("Array1: ");
	for(int i=0;i<7;i++){
	    System.out.print(max[i]+",");
	}
	System.out.println();
	System.out.println("Array2: ");
	for(int i=0;i<7;i++){
	    System.out.print(min[i]+",");
	}
	System.out.println();

	System.out.println();

	//check for median
	System.out.println("Median: "+rm.median());

	System.out.println();

	//remove median & check for consistency with above number
	System.out.println("Remove: "+rm.remove());

	System.out.println();

	//print arrays to see if it worked
	max=rm.getMax();
	min=rm.getMin();
	System.out.println("Array1: ");
	for(int i=0;i<7;i++){
	    System.out.print(max[i]+",");
	}
	System.out.println();
	System.out.println("Array2: ");
	for(int i=0;i<7;i++){
	    System.out.print(min[i]+",");
	}
	System.out.println();

    }

}
