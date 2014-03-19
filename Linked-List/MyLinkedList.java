import java.io.*;
import java.util.*;

public class MyLinkedList{

    private Node head;

    public MyLinkedList(){
	head=null;
    }

    //To-do list
    //make a method for adding another MyLinkedList into the current instance at any position, probably recursively

    public int length(){
	int len=0;
	Node current=head;
	while(current!=null){
	    len++;
	    current=current.getNext();
	}
	return len;
    }

    public Node accessNode(int position){
	if(position<0||position>length())
	    throw new NullPointerException();
	int currentPosition=0;
	Node current=head;
	while(currentPosition<position){
	    currentPosition++;
	    current=current.getNext();
	}
	return current;
    }

    public void set(int position, String newString){
	accessNode(position).setData(newString);	
    }

    public String get(int position){
	return accessNode(position).getData();
    }

    public void add(String s, int position){
	Node n=new Node(s);
	if(position<0||position>length())
	    throw new NullPointerException();
	if(position==0){
	    n.setNext(head);
	    head=n;
	}else if(position==length()){
	    accessNode(position-1).setNext(n);
	}else{
	    n.setNext(accessNode(position));
	    accessNode(position-1).setNext(n);
	}
    }

    public void add(String s){
	add(s,length());
    }

    public void add(Node n, int position){
	if(position<0||position>length())
	    throw new NullPointerException();
	if(position==0){
	    n.setNext(head);
	    head=n;
	}else if(position==length()){
	    accessNode(position-1).setNext(n);
	}else{
	    n.setNext(accessNode(position));
	    accessNode(position-1).setNext(n);
	}
    }

    public void add(Node n){
	add(n,length());
    }

    public void remove(int position){
	if(position<0||position>=length())
	    throw new NullPointerException();
	if(position==0){
	    head=head.getNext();
	}else if(position==length()-1){
	    accessNode(position-1).setNext(null);
	}else{
	    accessNode(position-1).setNext(accessNode(position).getNext());
	}
    }

    public int find(String s){
	int currentPosition=0;
	Node current=head;
	while(currentPosition<length()){
	    if(current.getData().equals(s))
		return currentPosition;
	    currentPosition++;
	    current=current.getNext();
	}
	return -1;
    }

    public String toString(){
	String ans = "[";
	int currentPosition=0;
	Node current=head;
	while(currentPosition<length()){
	    ans+=current.getData()+", ";
	}
	ans+="]";
	return ans;
    }

    //English is a cool language
    //head-tail; front-back; beginning-end; start-finish


}
