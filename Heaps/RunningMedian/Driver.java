import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	Random rand=new Random();
	RunningMedian rm=new RunningMedian();

	//put values in heaps
	for(int i=0;i<50;i++){
	    rm.add(rand.nextInt(100));
	}

	//print out arrays
	int[] max=rm.getMax();
	int[] min=rm.getMin();
	System.out.println("Array1: ");
	for(int i=0;i<27;i++){
	    System.out.print(max[i]+",");
	}
	System.out.println();
	System.out.println("Array2: ");
	for(int i=0;i<27;i++){
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

	System.out.println("Testing grow and shrink");
	System.out.println("Original length: "+rm.getMax().length);
	rm.grow();
	System.out.println("Length after grow: "+rm.getMax().length);
	rm.shrink();
	System.out.println("Length after shrink: "+rm.getMax().length);

	System.out.println();

	//print arrays to see if it worked
	max=rm.getMax();
	min=rm.getMin();
	System.out.println("Array1: ");
	for(int i=0;i<27;i++){
	    System.out.print(max[i]+",");
	}
	System.out.println();
	System.out.println("Array2: ");
	for(int i=0;i<27;i++){
	    System.out.print(min[i]+",");
	}
	System.out.println();

	//emptying container
	int size=rm.maxSize();
	while(size>0){
	    rm.remove();
	    size=rm.maxSize();
	}

	//print arrays to see if it worked
	max=rm.getMax();
	min=rm.getMin();
	System.out.println("Array1: ");
	for(int i=0;i<27;i++){
	    System.out.print(max[i]+",");
	}
	System.out.println();
	System.out.println("Array2: ");
	for(int i=0;i<27;i++){
	    System.out.print(min[i]+",");
	}
	System.out.println();

	//make sure exception is thrown appropriately
	System.out.println(rm.median());

    }

}
