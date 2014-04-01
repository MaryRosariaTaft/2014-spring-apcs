import java.io.*;
import java.util.*;

public class CircleLL<E>{

    private  class Node<E>{
	private E data;
	Node<E> next,prev;
	public Node(E d){
	    this.data=d;
	    next=this;
	    prev=this;
	}
	public void setData(E d){data=d;}
	public E getData(){return data;}
	public void setNext(Node<E> d){next=d;}
	public Node<E> getNext(){return next;}
	public void setPrev(Node<E> d){prev=d;}
	public Node<E> getPrev(){return prev;}
	public String toString(){return ""+data;}
    }

    private Node<E> current;

    public void insertBefore(E d){
	Node<E> n=new Node<E>(d);
	if(current==null)
	    current=n;
	else{
	    n.setPrev(current.getPrev());
	    current.getPrev().setNext(n);
	    n.setNext(current);
	    current.setPrev(n);
	    current=n;
	}
    }

    public void insertAfter(E d){
	Node<E> n=new Node<E>(d);
	if(current==null)
	    current=n;
	else{
	    n.setNext(current.getNext());
	    current.getNext().setPrev(n);
	    n.setPrev(current);
	    current.setNext(n);
	    current=n;
	}
    }

    public void forward(){
	current=current.getNext();
    }

    public void back(){
	current=current.getPrev();
    }

    public E getCurrent(){return current.getData();}

    public String toString(){
    	if(current==null) return "";
    	Node<E> temp=current;
    	String s="";
    	while(temp!=current){
    	    s+=temp.getData()+" ";
    	    temp=temp.getNext();
    	}
    	return s;
    }

}
