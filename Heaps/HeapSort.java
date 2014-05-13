import java.io.*;
import java.util.*;

public class HeapSort{

    public static void heapsort(int[] a){
	heapify(a);
	int end=a.length-1;
	while(end>=0){
	    //swap max with end of heap
	    //push down displaced value (not at the root) by swapping with children until it's in the correct place
	    swap(a,0,end);
	    pushDown(a,0,end);
	    end--;
	}
    }
    
    //max heap
    public static void heapify(int[] a){
	int i=0;
	while(i<a.length){
	    //push up children if they're bigger than their parents
	    if(a[i]>a[parentIndex(i)])
		pushUp(a,i);
	    i++;
	}
    }

    public static int parentIndex(int index){
	return (index-1)/2;
    }

    public static int childIndex(int index, int end){
	int leftChild=2*index+1;
	int rightChild=leftChild+1;
	//check index against array length so as not to go out of bounds
	//right child preferable
	if(rightChild<end)
	    return rightChild;
	//left child otherwise
	if(leftChild<end)
	    return leftChild;
	//no children
	return index;
    }

    public static void pushUp(int[] a, int index){
	while(a[index]>a[parentIndex(index)]){
	    swap(a,index,parentIndex(index));
	    index=parentIndex(index);
	}
    }

    public static void pushDown(int[]a, int index, int end){
	int child=childIndex(index,end);
	if(index!=child){
	    swap(a,index,child);
	    index=child;
	    pushDown(a,index,end);
	}
    }

    // public static void pushDown(int[] a, int index, int end){
    // 	while(a[index]<a[childIndex(index,end)]){
    // 	    swap(a,index,childIndex(index,end));
    // 	    index=childIndex(index,end);
    // 	}
    // }
    

    public static void swap(int[] a, int x, int y){
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
    }

    public static void main(String[] args){
	int[] a={5,1,7,4,3,0,2,9,6,8};
	System.out.println(Arrays.toString(a));
	heapify(a);
	System.out.println(Arrays.toString(a));
	heapsort(a);
	System.out.println(Arrays.toString(a));	
    }

}
