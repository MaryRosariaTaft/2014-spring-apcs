// import java.io.*;
// import java.util.*;

// public class Driver{

//     public static void main(String[] args){

// 	MyStack<Integer> ms = new MyStack<Integer>();
// 	ms.push(8);
// 	System.out.println(ms);
// 	ms.push(8);
// 	ms.push(9);
// 	ms.push(4);
// 	ms.push(10);
// 	ms.push(3);
// 	ms.push(3);
// 	ms.push(3);
// 	ms.push(3);
// 	ms.push(123);
// 	System.out.println(ms);
// 	System.out.println(ms.pop());
// 	System.out.println(ms);
// 	System.out.println("First occurrence of 3: "+ms.search(3));
// 	System.out.println("First occurrence of 66: "+ms.search(66));

// 	MyStackArrays<Integer> msa = new MyStackArrays<Integer>();
// 	msa.push(8);
// 	System.out.println(msa);
// 	msa.push(8);
// 	msa.push(9);
// 	msa.push(4);
// 	msa.push(10);
// 	msa.push(3);
// 	msa.push(3);
// 	msa.push(3);
// 	msa.push(3);
// 	msa.push(123);
// 	System.out.println(msa);
// 	System.out.println(msa.pop());
// 	System.out.println(msa);
// 	System.out.println("First occurrence of 3: "+msa.search(3));
// 	System.out.println("First occurrence of 66: "+msa.search(66));


//     }

// }


//Driver credit to Andrew Fischer

import java.io.*;
import java.util.*;


public class Driver{

    public static int Min = 0;
    public static int Max = 1000000;
    public static Random r = new Random();

    public static void pushpop(int reps, MyArrayStack stk){
	for (int i = 0; i<reps; i++){
	    stk.push(r.nextInt());
	}
	for (int i = 0; i<reps; i++){
	    stk.pop();
	}
    }
    
    
    public static void randompushpop(int reps, MyArrayStack stk){
	for (int i=0; i<10000000;i++){stk.push(r.nextInt());}
	while (reps > 0){
	    if ((int)r.nextInt() % 2 == 1){
		stk.push(r.nextInt());
		reps--;
	    }
	    else{
		stk.pop();
		reps--;
	    }
	}
    }
         public static void pushpop(int reps, MyStack stk){
	for (int i = 0; i<reps; i++){
	    stk.push(r.nextInt());
	}
	for (int i = 0; i<reps; i++){
	    stk.pop();
	}
    }
    
    
    public static void randompushpop(int reps, MyStack stk){
	for (int i=0; i<10000000;i++){stk.push(r.nextInt());}
	while (reps > 0){
	    if ((int)r.nextInt() % 2 == 1){
		stk.push(r.nextInt());
		reps--;
	    }
	    else{
		stk.pop();
		reps--;
	    }
	}
    }
     
    
    public static void main(String args[]){

	long start,stop,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

	// System.out.println("Initializing MyArrayStack...");
	// MyArrayStack stk = new MyArrayStack();
	// System.out.println("Success!");


	// System.out.println("\n-----\n\nBEGINNING SIMPLE TESTS");
	// stk.push("Testing 1 element stack...");
	// System.out.println(stk.pop());
	// System.out.println("Success!");
    

	// System.out.println("\n-----\n\nBEGINNING ORDERED TESTS");

	// start = System.currentTimeMillis();
	// System.out.print("100 Elements...");
	// pushpop(100, stk);
	// System.out.println("\t\t\t[OK]");
	// stop  = System.currentTimeMillis();
	// t1=stop-start;
	// System.out.println("\t" + t1 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("10000 Elements...");
	// pushpop(10000, stk);
	// System.out.println("\t\t[OK]");
	// stop  = System.currentTimeMillis();
	// t2=stop-start;
	// System.out.println("\t" + t2 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("100000 Elements...");
	// pushpop(100000, stk);
	// System.out.println("\t\t[OK]");
	// stop  = System.currentTimeMillis();
	// t3=stop-start;
	// System.out.println("\t" + t3 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("1000000 Elements...");
	// pushpop(1000000, stk);
	// System.out.println("\t\t[OK]");
	// stop  = System.currentTimeMillis();
	// t4=stop-start;
	// System.out.println("\t" + t4 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("10000000 Elements...");
	// pushpop(10000000, stk);
	// System.out.println("\t\t[OK]");
	// stop  = System.currentTimeMillis();
	// t5=stop-start;
	// System.out.println("\t" + t5 + " ms");

	// System.out.println("\n-----\n\nBEGINNING RANDOMIZED TESTS");


	// start = System.currentTimeMillis();
	// System.out.print("100 Elements...");
	// randompushpop(100, stk);
	// System.out.println("\t\t\t[OK]");
	// stop = System.currentTimeMillis();
	// t6=stop-start;
	// System.out.println("\t" + t6 + " ms");


	// start = System.currentTimeMillis();
	// System.out.print("10000 Elements...");
	// randompushpop(10000, stk);
	// System.out.println("\t\t\t[OK]");
	// stop = System.currentTimeMillis();
	// t7=stop-start;
	// System.out.println("\t" + t7 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("100000 Elements...");
	// randompushpop(100000, stk);
	// System.out.println("\t\t\t[OK]");
	// stop = System.currentTimeMillis();
	// t8=stop-start;
	// System.out.println("\t" + t8 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("1000000 Elements...");
	// randompushpop(1000000, stk);
	// System.out.println("\t\t\t[OK]");
	// stop = System.currentTimeMillis();
	// t9=stop-start;
	// System.out.println("\t" + t9 + " ms");

	// start = System.currentTimeMillis();
	// System.out.print("10000000 Elements...");
	// randompushpop(10000000, stk);
	// System.out.println("\t\t\t[OK]");
	// stop = System.currentTimeMillis();
	// t10=stop-start;
	// System.out.println("\t" + t10 + " ms");

	System.out.println("Initializing MyStack...");
	MyStack stk = new MyStack();
	System.out.println("Success!");


	System.out.println("\n-----\n\nBEGINNING SIMPLE TESTS");
	stk.push("Testing 1 element stack...");
	System.out.println(stk.pop());
	System.out.println("Success!");
    

	System.out.println("\n-----\n\nBEGINNING ORDERED TESTS");

	start = System.currentTimeMillis();
	System.out.print("100 Elements...");
	pushpop(100, stk);
	System.out.println("\t\t\t[OK]");
	stop  = System.currentTimeMillis();
	t1=stop-start;
	System.out.println("\t" + t1 + " ms");

	start = System.currentTimeMillis();
	System.out.print("10000 Elements...");
	pushpop(10000, stk);
	System.out.println("\t\t[OK]");
	stop  = System.currentTimeMillis();
	t2=stop-start;
	System.out.println("\t" + t2 + " ms");

	start = System.currentTimeMillis();
	System.out.print("100000 Elements...");
	pushpop(100000, stk);
	System.out.println("\t\t[OK]");
	stop  = System.currentTimeMillis();
	t3=stop-start;
	System.out.println("\t" + t3 + " ms");

	start = System.currentTimeMillis();
	System.out.print("1000000 Elements...");
	pushpop(1000000, stk);
	System.out.println("\t\t[OK]");
	stop  = System.currentTimeMillis();
	t4=stop-start;
	System.out.println("\t" + t4 + " ms");

	start = System.currentTimeMillis();
	System.out.print("10000000 Elements...");
	pushpop(10000000, stk);
	System.out.println("\t\t[OK]");
	stop  = System.currentTimeMillis();
	t5=stop-start;
	System.out.println("\t" + t5 + " ms");

	System.out.println("\n-----\n\nBEGINNING RANDOMIZED TESTS");


	start = System.currentTimeMillis();
	System.out.print("100 Elements...");
	randompushpop(100, stk);
	System.out.println("\t\t\t[OK]");
	stop = System.currentTimeMillis();
	t6=stop-start;
	System.out.println("\t" + t6 + " ms");


	start = System.currentTimeMillis();
	System.out.print("10000 Elements...");
	randompushpop(10000, stk);
	System.out.println("\t\t\t[OK]");
	stop = System.currentTimeMillis();
	t7=stop-start;
	System.out.println("\t" + t7 + " ms");

	start = System.currentTimeMillis();
	System.out.print("100000 Elements...");
	randompushpop(100000, stk);
	System.out.println("\t\t\t[OK]");
	stop = System.currentTimeMillis();
	t8=stop-start;
	System.out.println("\t" + t8 + " ms");

	start = System.currentTimeMillis();
	System.out.print("1000000 Elements...");
	randompushpop(1000000, stk);
	System.out.println("\t\t\t[OK]");
	stop = System.currentTimeMillis();
	t9=stop-start;
	System.out.println("\t" + t9 + " ms");

	start = System.currentTimeMillis();
	System.out.print("10000000 Elements...");
	randompushpop(10000000, stk);
	System.out.println("\t\t\t[OK]");
	stop = System.currentTimeMillis();
	t10=stop-start;
	System.out.println("\t" + t10 + " ms");


    }  
    
}
