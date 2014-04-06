import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){

	MyStack<Integer> ms = new MyStack<Integer>();
	ms.push(8);
	System.out.println(ms);
	ms.push(8);
	ms.push(9);
	ms.push(4);
	ms.push(10);
	ms.push(3);
	ms.push(3);
	ms.push(3);
	ms.push(3);
	ms.push(123);
	System.out.println(ms);
	System.out.println(ms.pop());
	System.out.println(ms);
	System.out.println("First occurrence of 3: "+ms.search(3));
	System.out.println("First occurrence of 66: "+ms.search(66));

	MyStackArrays<Integer> msa = new MyStackArrays<Integer>();
	msa.push(8);
	System.out.println(msa);
	msa.push(8);
	msa.push(9);
	msa.push(4);
	msa.push(10);
	msa.push(3);
	msa.push(3);
	msa.push(3);
	msa.push(3);
	msa.push(123);
	System.out.println(msa);
	System.out.println(msa.pop());
	System.out.println(msa);
	System.out.println("First occurrence of 3: "+msa.search(3));
	System.out.println("First occurrence of 66: "+msa.search(66));


    }

}
