import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	int size=(int)(Integer.parseInt(args[0]));
	for(int seed=1;seed<args.length;seed++){
	    Random R=new Random((int)(Integer.parseInt(args[seed])));

	    System.out.println("Test 1");
	    System.out.println();
	    test1(R,size);

	    System.out.println("__________________________");
	    System.out.println();
	    System.out.println("Test 2");
	    System.out.println();
	    test2(R,size);
	}
    }

    public static void test1(Random R, int size){

	RunningMedian rm=new RunningMedian();

	//put values in heaps
	for(int i=0;i<size;i++){
	    int temp=R.nextInt(100)+1;
	    rm.add(temp);
	    System.out.print("Added "+temp+"; ");
	    System.out.println("median is now "+rm.median()+".");
	    System.out.println(rm);
	}

    }

    public static void test2(Random R, int size){

	RunningMedian rm=new RunningMedian();

	for(int i=0;i<size;i++){

	    //put values in heaps
	    int temp=R.nextInt(100)+1;
	    rm.add(temp);
	    System.out.print("Added "+temp+"; ");
	    System.out.println("median is now "+rm.median()+".");
	    System.out.println(rm);

	    //20% chance of removing value
	    if(Math.random()<0.2){
		rm.remove();
		System.out.println("Removed median(s).");
		System.out.println(rm);
	    }

	}

    }


}
