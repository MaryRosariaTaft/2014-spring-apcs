import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	MyLinkedList L = new MyLinkedList();
	L.add("test0",0);
	L.add("test1",1);
	L.add("test2");
	L.add("test1.5",2);
	System.out.println(L);
	L.remove(1);
	System.out.println(L);
	System.out.println("Index of the first occurrence of \"test2\": "+L.find("test2"));
	L.add(new Node("testNode"));
	System.out.println(L);
	System.out.println("Length: "+L.length());
	L.add("outofboundstest",-1);
	
	MyLinkedList L2 = new MyLinkedList();
	L2.add("mergeTest1");
	L2.add("mergeTest2");
	L2.add("mergeTest3");

	System.out.println(L2);

	// L.merge(L2,0);
	// System.out.println(L);
    }

}
