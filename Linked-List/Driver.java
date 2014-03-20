import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	Node n=new Node("test");
	MyLinkedList L = new MyLinkedList();
	L.add("test0",0);
	L.add("test1",1);
	L.add("test2");
	L.add("test1.5",2);
	System.out.println(L);
	L.remove(1);
	System.out.println(L);
	System.out.println("Index of the first occurrence of \"test2\": "+L.find("test2"));
    }

}
