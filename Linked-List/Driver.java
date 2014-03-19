import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	Node n=new Node("test");
	MyLinkedList L = new MyLinkedList();
	L.add(n);
	System.out.println(L);
    }

}
