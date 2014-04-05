import java.io.*;
import java.util.*;

public class MyStack<E>{

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

    private Node<E> top;

    public MyStack(){
	top=null;
    }

    public boolean empty(){
	return top==null;
    }

    public E peek(){
	if(empty())
	    throw new EmptyStackException();
	return top.getData();
    }

    public E pop(){
	E temp=peek();
	top=top.getNext();
	return temp;
    }

    public void push(E d){
	Node<E> temp=new Node<E>(d);
	temp.setNext(top);
	top=temp;
    }

    public int search(Object o){
	int pos=1;
	Node<E> current=top;
	while(current!=null){
	    if(current.getData().equals(o))
		return pos;
	    pos++;
	    current=current.getNext();
	}
	return -1;
    }

    public String toString(){
	String s="";
	Node<E> current=top;
	while(current!=null){
	    s=current.toString()+" "+s;
	    current=current.getNext();
	}
	return s;
    }

}
