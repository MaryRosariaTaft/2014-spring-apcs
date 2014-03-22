import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){

	MyLinkedList<String> L = new MyLinkedList<String>();

	System.out.println("List 1: Strings");
	System.out.println();

	L.add("test0",0);
	L.add("test1",1);
	L.add("test2");
	L.add("test1.5",2);
	System.out.println("Added 4 elements.");
	System.out.println(L);
	System.out.println();

	L.remove(1);
	System.out.println("Removed 1 element.");
	System.out.println(L);
	System.out.println();

	System.out.println("Index of the first occurrence of \"test2\": "+L.find("test2"));
	System.out.println();

	L.add(new Node<String>("testNode"));
	System.out.println("Added 1 elements.");
	System.out.println(L);
	System.out.println();

	System.out.println("Length: "+L.length());
	System.out.println();

	L.remove(0);
	System.out.println("Removed the first element.");
	System.out.println(L);
	System.out.println();

	L.remove(L.length()-1);
	System.out.println("Removed the last element.");
	System.out.println(L);
	System.out.println();

	// L.add("outofboundstest",-1);
	
	//

	MyLinkedList<Integer> L2 = new MyLinkedList<Integer>();

	System.out.println("List 2: Integers");
	System.out.println();

	L2.add(11,0);
	L2.add(22,1);
	L2.add(33);
	L2.add(17,2);
	System.out.println("Added 4 elements.");
	System.out.println(L2);
	System.out.println();

	L2.remove(1);
	System.out.println("Removed 1 element.");
	System.out.println(L2);
	System.out.println();

	System.out.println("Index of the first occurrence of 17: "+L2.find(17));
	System.out.println();

	L2.add(new Node<Integer>(42));
	System.out.println("Added 1 elements.");
	System.out.println(L2);
	System.out.println();

	System.out.println("Length: "+L2.length());
	System.out.println();

	L2.remove(0);
	System.out.println("Removed the first element.");
	System.out.println(L2);
	System.out.println();

	L2.remove(L2.length()-1);
	System.out.println("Removed the last element.");
	System.out.println(L2);
	System.out.println();

	//

	// L.merge(L2,0);
	// System.out.println(L);
    }

}
