import java.io.*;
import java.util.*;

public class HeapSort{

    public static void heapsort(int[] a){
	heapify(a);
	int end=a.length-1;
	while(end>0){
	    swap(a,0,end);
	    pushDown(a,0,end);
	    end--;
	}
    }

    public static void heapify(int[] a){
	int i=0;
	while(i<a.length){
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

    //CAN'T TOUCH THE UPPER BOUND
    public static void pushDown(int[] a, int index, int upperBound){
	while(index*2+1<upperBound){
	    int child=index*2+1;
	    int swapIndex=index;
	    if(a[swapIndex]<a[child])
		swapIndex=child;
	    if(child+1<upperBound)
	        if(a[swapIndex]<a[child+1])
		    swapIndex=child+1;
	    if(index!=swapIndex){
		swap(a,index,swapIndex);
		index=swapIndex;
	    }
	    else
		break;
	}

	// //return if no children
	// if(2*index+1>=upperBound)
	//     return;
	// //if only left child, check if swapping is necessary
	// if(2*index+2>=upperBound){
	//     if(a[index]<a[2*index+1]){
	// 	swap(a,index,2*index+1);
	// 	pushDown(a,2*index+1,upperBound);
	//     }
	// }
	// //if both children, check which is bigger, then check if swapping is necessary
	// if(a[index]<a[2*index+1]&&a[2*index+1]>a[2*index+2]){
	//     swap(a,index,2*index+1);
	//     pushDown(a,2*index+1,upperBound);
	// }else if(a[index]<a[2*index+2]){
	//     swap(a,index,2*index+2);
	//     pushDown(a,2*index+2,upperBound);
	// }
    }

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
