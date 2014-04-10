import java.io.*;
import java.util.*;

public class MyQueue<E>{

    private class Node<E>{
	private E data;
	private Node<E> next;
	public Node(E data){this.data=data;next=null;}
	public void setData(E data){this.data=data;}
	public void setNext(Node<E> next){this.next=next;}
	public E getData(){return data;}
	public Node<E> getNext(){return next;}
	public String toString(){return data.toString();}
    }

    private Node<E> head,tail;
    private int size;

    public MyQueue(){
	head=null;//first out
	tail=null;//last in
	size=0;
    }

    public int size(){
	return size;
    }

    public void enqueue(E d){
	if(d==null)
	    throw new NullPointerException("Null elements not permitted.");
	//or IllegalArgumentException
	Node<E> temp=new Node(d);
	if(size==0){
	    head=temp;
	}else{
	    tail.setNext(temp);
	}
	tail=temp;
	size++;
    }

    public E peek(){
	if(size==0)
	    return null;
	return head.getData();
    }

    public E dequeue(){
	E temp=peek();
	if(head.getNext()!=null)
	    head=head.getNext();
	size--;
	return temp;

    }

    public String toString(){
	String s="";
	Node<E> current=head;
	while(current!=null){
	    s=s+current.toString()+", ";
	    current=current.getNext();
	}
	if(!s.equals(""))
	    s=s.substring(0,s.length()-3);
	return "Ordered first to last: ["+s+"]";
    }

}
