import java.io.*;
import java.util.*;

public class MyLinkedListIterator<T> implements Iterator<T>{

    private Node<T> current;
    
    public MyLinkedListIterator(Node<T> head){
	current=head.getNext();
    }

    public boolean hasNext(){
	return current!=null;
    }

    public T next(){
	if(hasNext()){
	    T temp=current.getData();
	    current=current.getNext();
	    return temp;
	}
	throw new NoSuchElementException();
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

}
