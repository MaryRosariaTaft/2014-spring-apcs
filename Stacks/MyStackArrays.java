import java.io.*;
import java.util.*;

public class MyStackArrays<E>{

    private E[] stack;

    public MyStackArrays(){
        stack=new E[0];
    }

    public boolean empty(){
	return stack.length>0;
    }

    public E peek(){
	if(empty())
	    throw new EmptyStackException();
	return stack[0];
    }

    public E pop(){
	E ans=stack[stack.length-1];
	E[] temp=new E[stack.length-1];
	for(int i=0;i<temp.length;i++)
	    temp[i]=stack[i];
	return ans;
    }

    public void push(E d){
	E[] temp=new E[stack.length+1];
	for(int i=0;i<stack.length;i++)
	    temp[i]=stack[i];
        temp[temp.length-1]=d;
    }

    public int search(Object o){
	for(int i=0;i<stack.length;i++){
	    if(stack[i].equals(o))
		return i;
	}
	return -1;
    }

    public String toString(){
	String s="";
	for(int i=0;i<stack.length;i++)
	    s+=stack[i].toString()+" ";
	return s;
    }

}
