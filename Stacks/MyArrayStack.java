import java.io.*;
import java.util.*;

public class MyArrayStack<E>{

    private E[] stack;
    private int size;

    public MyArrayStack(){
        stack=(E[])(new Object[100]);
	size=0;
    }

    public int size(){
	return size;
    }

    public void grow(){
	E[] temp=(E[])(new Object[stack.length*2]);
	for(int i=0;i<size;i++){
	    temp[i]=stack[i];
	}
	stack=temp;
    }

    public void shrink(){
	E[] temp=(E[])(new Object[stack.length/2]);
	for(int i=0;i<size;i++){
	    temp[i]=stack[i];
	}
	stack=temp;
    }

    public boolean empty(){
	return stack.length<=0;
    }

    public E peek(){
	if(empty())
	    throw new EmptyStackException();
	return stack[size-1];
    }

    public E pop(){
	E ans=peek();
	size--;
	if(size>1000&&size<=stack.length/4)
	    shrink();
	return ans;
    }

    public void push(E d){
	if(stack.length==size)
	    grow();
	stack[size]=d;
	size++;
	
    }

    public int search(Object o){
	for(int i=0;i<stack.length;i++){
	    if(stack[i].equals(o))
		return i;
	}
	return -1;
    }

    public String toString(){
	return Arrays.toString(stack);
    }

}
