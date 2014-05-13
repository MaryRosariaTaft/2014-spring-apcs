import java.io.*;
import java.util.*;

public class HeapSort{

    public static void heapsort(int[] a){
	//make a heap
	heapify(a);
	int end=a.length-1;
	while(end>0){
	    //remove the root and put it in the freed up space of the array
	    swap(a,0,end);
	    //put the displaced value in its correct spot
	    pushDown(a,0,end);
	    //decrement the end value so that it will be separated as part of the sorted list, not part of the heap
	    end--;
	}
    }

    public static void heapify(int[] a){
	int i=0;
	//for every value, is the value at some index is greater than the value of its parent, push it up to the proper location; the final product is an array like this:
	//[root,1st layer_left,1st layer_right,2nd layer_left_left,2nd layer_left_right,2nd layer_right_left,2nd layer_right_right,...] and so on
	//example - [9,8,7,6,3,4,2] represents the following heap:
	//     9
	//   8   7
	//  6 3 4 2
	while(i<a.length){
	    //(i-1)/2 is the index of the given index's parent
	    if(a[i]>a[(i-1)/2])
		pushUp(a,i);
	    i++;
	}
    }

    public static void pushUp(int[] a, int index){
	//(index-1)/2 is the index of the given index's parent
	while(a[index]>a[(index-1)/2]){
	    swap(a,index,(index-1)/2);
	    index=(index-1)/2;
	}
    }

    public static void pushDown(int[] a, int index, int upperBound){
	//while the index has at least one child (the left child)
	while(index*2+1<upperBound){
	    //assign the child as the left child
	    int child=index*2+1;
	    //make a variable to store which index the given index will potentially be swapped with
	    int swapIndex=index;
	    //if the left child is greater than the parent (the value at the given index)
	    if(a[swapIndex]<a[child])
		swapIndex=child;
	    //if the right child exists
	    if(child+1<upperBound)
		//if it's greater than the left child (since the parent should be swapped with the LARGER of the two children)
	        if(a[swapIndex]<a[child+1])
		    swapIndex=child+1;
	    //swap the value at the given index with the proper child if necessary
	    if(index!=swapIndex){
		swap(a,index,swapIndex);
		index=swapIndex;
	    }
	    //value at index is in the correct place
	    else
		break;
	}
    }

    public static void swap(int[] a, int x, int y){
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
    }

    public static void main(String[] args){
	int[] a={5,1,7,4,3,0,2,9,6,8};
	System.out.println("Original array: "+Arrays.toString(a));
	heapify(a);
	System.out.println("Converted into a heap: "+Arrays.toString(a));
	heapsort(a);
	System.out.println("Sorter using heap sort: "+Arrays.toString(a));	
    }

}
