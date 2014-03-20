import java.io.*;
import java.util.*;

public class MyLinkedList{

    public Node head;

    public MyLinkedList(){
	head=null;
    }

    //returns length of the linked list
    public int length(){
	int len=0;
	Node current=head;
	while(current!=null){
	    len++;
	    current=current.getNext();
	}
	return len;
    }

    //returns the Node at desired index
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

    //changes the data of Node at desired index
    public void set(int position, String newString){
	accessNode(position).setData(newString);	
    }

    //returns String data contained at Node at position
    public String get(int position){
	return accessNode(position).getData();
    }

    //creates new Node and adds it to desired index
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

    //creates new Node and adds it to end
    public void add(String s){
	add(s,length());
    }

    //adds Node n at desired index
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

    //adds Node n to end
    public void add(Node n){
	add(n,length());
    }

    //removes Node at said position
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

    //returns the index of the first occurrence of String s
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

    //appends L onto this instance of MyLinkedList
    public void merge(MyLinkedList L){
	// int currentPosition=0;
	// Node current=L.head;
	// while(currentPosition<L.length()){
	//     add(current);
	//     currentPosition++;
	//     current=current.getNext();
	// }
	merge(L,length());
    }


    public void merge(MyLinkedList L, int position){
	int currentPosition=L.length()-1;
	Node current=L.head;
	while(currentPosition>=0){
	    add(current);
	    currentPosition--;
	    current=current.getNext();
	}
    }

    public String toString(){
	String ans="[";
	int currentPosition=0;
	Node current=head;
	while(currentPosition<length()){
	    ans+=current.getData()+", ";
	    currentPosition++;
	    current=current.getNext();
	}
	return ans+"]";
    }

    //English is a cool language
    //head-tail; front-back; beginning-end; start-finish
    //big-little; large-small


}
