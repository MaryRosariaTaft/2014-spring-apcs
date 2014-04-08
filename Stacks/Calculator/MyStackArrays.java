import java.io.*;
import java.util.*;

public class MyStackArrays<E>{

    private E[] stack;

    public MyStackArrays(){
        stack=(E[])(new Object[0]);
    }

    public boolean empty(){
	return stack.length<=0;
    }

    public E peek(){
	if(empty())
	    throw new EmptyStackException();
	return stack[stack.length-1];
    }

    public E pop(){
	E ans=peek();
	Object[] temp=(E[])(new Object[stack.length-1]);
	for(int i=0;i<temp.length;i++)
	    temp[i]=stack[i];
	stack=(E[])temp;
	return ans;
    }

    public void push(E d){
	Object[] temp=(E[])(new Object[stack.length+1]);
	for(int i=0;i<stack.length;i++)
	    temp[i]=stack[i];
        temp[temp.length-1]=d;
	stack=(E[])temp;
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
