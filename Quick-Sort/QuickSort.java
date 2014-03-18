import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSort{

    private static Random rand = new Random();

    public static void quicksort(int[]L){
	quicksort(L,0,L.length-1);
    }

    public static void quicksort(int[]L,int left,int right){
	//stop recursion when length is 0 or 1
	if(right-left+1>1){	   
	    int pivotIndex=partition(L,left,right);
	    //sort each "half"
	    quicksort(L,left,pivotIndex-1);
	    quicksort(L,pivotIndex+1,right);
	}
    }

    public static void swap(int[] L, int i, int index){
	int temp=L[i];
	L[i]=L[index];
	L[index]=temp;
    }

    public static int partition(int[] L, int left, int right){

    	int frontIndex=left,
	    temp=0,
	    pivotInitialIndex=left+rand.nextInt(right-left),
	    pivotNum=L[pivotInitialIndex];

	//System.out.println("Pivot number: "+pivotNum);

    	//move the numbers smaller than pivotNum to the front
    	for(int i=left;i<=right;i++){
    	    if(L[i]<pivotNum){
		swap(L,frontIndex,i);
    	    	frontIndex++;
    	    }
	    //System.out.println(Arrays.toString(L));
    	}

	//to be used for finding the partition index
	int start=frontIndex,
	    end=frontIndex;

	//move duplicates of pivotNum to the beginning of the right side of the partition
	for(int i=frontIndex;i<=right;i++){
	    if(L[i]==pivotNum){
		swap(L,frontIndex,i);
		end=frontIndex; //find the index of the last duplicate of pivotNum
		frontIndex++;
	    }
	    //System.out.println(Arrays.toString(L));
	}

	// System.out.println("Start: "+start+"\nEnd: "+end);

	//average of start and end values (if there are duplicates of pivotNum)
    	return (start+end)/2;
    }

    // Other partition method: not good for duplicates

    // public static int partition1(int[] L, int left, int right){
    // 	//random partition number
    // 	int frontIndex=left, temp=0, pivotInitialIndex=left+rand.nextInt(right-left), pivotNum=L[pivotInitialIndex];
    // 	//store the pivot at end
    // 	temp=pivotNum;
    // 	L[pivotInitialIndex]=L[right];
    // 	L[right]=temp;
    // 	//push elements greater than pivotNum to the right
    // 	for(int i=left;i<right;i++){
    // 	    if(L[i]<=pivotNum){
    // 	    	temp=L[frontIndex];
    // 	    	L[frontIndex]=L[i];
    // 	    	L[i]=temp;
    // 	    	frontIndex++;
    // 	    }
    // 	}
    // 	//put the pivot back where it belongs
    // 	temp=L[frontIndex];
    // 	L[frontIndex]=L[right];
    // 	L[right]=temp;
    // 	return frontIndex;
    // }

    // public static void main(String[] args){
    // 	int[] a = {0,1,2,3,4,5,6,7,8,9};
    // 	int[] b = {9,8,7,6,5,4,3,2,1,0};
    // 	int[] c = {2,2,2,2,2,2,2,1,3,2,2,4};
    // 	int[] d = {7,2,7,9,4,7,7,3,11,44,1,45,7,666,33,9,4,6,2,8,8888,8,4,2};

    // System.out.println("Original array: "+Arrays.toString(a));
    // partition(a,0,a.length-1);
    // System.out.println("Pivot index: "+pos);
    // System.out.println("Partitioned array: "+Arrays.toString(a));

    // 	quicksort(a);
    // 	System.out.println(Arrays.toString(a));

    // 	quicksort(b);
    // 	System.out.println(Arrays.toString(b));

    // 	quicksort(c);
    // 	System.out.println(Arrays.toString(c));

    // 	quicksort(d);
    // 	System.out.println(Arrays.toString(d));

    // }

}

