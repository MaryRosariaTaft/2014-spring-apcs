import java.io.*;
import java.util.*;

public class DoubleLL<E>{

    private  class Node<E>{
	private E data;
	Node<E> next,prev;
	public Node(E d){this.data=d;}
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
	    if(current.getPrev()!=null){
		n.setPrev(current.getPrev());
		current.getPrev().setNext(n);
	    }
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
	    if(current.getNext()!=null){
		n.setNext(current.getNext());
		current.getNext().setPrev(n);
	    }
	    n.setPrev(current);
	    current.setNext(n);
	    current=n;
	}
    }

    public void forward(){
	if(current.getNext()!=null) current=current.getNext();
    }

    public void back(){
	if(current.getPrev()!=null) current=current.getPrev();
    }

    public E getCurrent(){ return current.getData();}

    public String toString(){
	if(current==null) return "";
	Node<E> temp=current;
	while(temp.getPrev()!=null)
	    temp=temp.getPrev();
	String s="";
	while(temp!=null){
	    s+=temp.getData()+" ";
	    temp=temp.getNext();
	}
	return s;
    }

}
