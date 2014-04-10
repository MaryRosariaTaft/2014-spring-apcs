import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){
	MyQueue<String> q=new MyQueue<String>();
	System.out.println(q);
	System.out.println("Peeking: "+q.peek());
	System.out.println("Size: "+q.size());
	q.enqueue("test1");
	System.out.println(q);
	q.enqueue("test2");
	System.out.println(q);
	q.enqueue("test3");
	System.out.println(q);
	q.enqueue("test4");
	System.out.println(q);
	q.enqueue("test5");
	System.out.println(q);
	System.out.println("Size: "+q.size());
	System.out.println("Dequeuing: "+q.dequeue());
	System.out.println(q);
	System.out.println("Size: "+q.size());
	System.out.println("Peeking: "+q.peek());
	System.out.println(q);
	System.out.println("Size: "+q.size());
    }

}
