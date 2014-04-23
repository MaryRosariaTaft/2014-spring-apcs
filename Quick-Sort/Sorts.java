import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class Sorts{

    private static Random rand = new Random();

    public static String name(){
	return "Taft, Mary";
    }

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

}

