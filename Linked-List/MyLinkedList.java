import java.io.*;
import java.util.*;

public class MyLinkedList{

    private Node head;

    public MyLinkedList(){
	head=null;
    }

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
	accessNode(position).getData();
    }

    public void add(String s, int position){
	Node n=new Node(s);
	n.setNext(accessNode(position).getNext);
	accessNode(position)=n;
	//this isn't complete
    }

    public void remove(int position){
	//remore node at position
    }

    public int find(String s){
	//base cases?
	//return index of first occurrence of s
	//-1 if it isn't in the List
    }

    public String toString(){
	String ans = "[";
	while(){

	}
	ans+="]";
	return ans;
    }

}