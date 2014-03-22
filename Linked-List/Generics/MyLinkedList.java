import java.io.*;
import java.util.*;

public class MyLinkedList<T>{

    public Node<T> head;
    private int length;

    public MyLinkedList(){
	head=new Node<T>(null);
	length=0;
    }

    //returns length of the linked list
    public int length(){
	return length;
    }

    //returns the Node at desired index
    public Node<T> accessNode(int position){
	if(position==-1)
	    return head;
	if(position<0||position>length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	int currentPosition=0;
	Node<T> current=head.getNext();
	while(currentPosition<position){
	    currentPosition++;
	    current=current.getNext();
	}
	return current;
    }

    //changes the data of Node at desired index
    public void set(int position, T newData){
	if(position<0||position>length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	accessNode(position).setData(newData);	
    }

    //returns String data contained at Node at position
    public T get(int position){
	if(position<0||position>length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	return accessNode(position).getData();
    }

    //creates new Node and adds it to desired index
    public void add(T s, int position){
	if(position<0||position>length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	Node<T> n=new Node<T>(s), temp=accessNode(position-1);
	n.setNext(temp.getNext());
	temp.setNext(n);
	length++;
    }

    //creates new Node and adds it to end
    public void add(T s){
	add(s,length());
    }

    //adds Node n at desired index
    public void add(Node<T> n, int position){
	if(position<0||position>length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	Node<T> temp=accessNode(position-1);
	n.setNext(temp.getNext());
	temp.setNext(n);
	length++;
    }

    //adds Node n to end
    public void add(Node<T> n){
	add(n,length());
    }

    //removes Node at said position
    public void remove(int position){
	if(position<0||position>=length())
	    throw new IndexOutOfBoundsException("Out of bounds: "+position);
	Node<T> temp=accessNode(position-1);
	temp.setNext(temp.getNext().getNext());
	length--;
    }

    //returns the index of the first occurrence of String s
    public int find(T s){
	int currentPosition=0;
	Node<T> current=head.getNext();
	while(currentPosition<length()){
	    if(current.getData().equals(s))
		return currentPosition;
	    currentPosition++;
	    current=current.getNext();
	}
	return -1;
    }

    //Commented out regions don't work

    // public void merge(MyLinkedList L){
    // 	merge(L,length());
    // }

    // public void merge(MyLinkedList L, int position){
    // 	Node current=L.accessNode(0);
    // 	while(current.getNext()!=null){
    // 	    add(current);
    // 	    current=current.getNext();
    // 	}
    // }

    public String toString(){
	String ans="[";
	int currentPosition=0;
	Node<T> current=head.getNext();
	while(currentPosition<length()-1){
	    ans+=current.getData().toString()+", ";
	    currentPosition++;
	    current=current.getNext();
	}
	return ans+current.getData().toString()+"]";
    }

    //English is a cool language
    //head-tail; front-back; beginning-end; start-finish
    //big-little; large-small


}
