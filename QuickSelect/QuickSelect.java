import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

//quick sort
//get rid of base case
//new base case: if (right-left)<2
//get rid of k

    private static Random rand = new Random();

    public static void quicksort(int[]L){
	quicksort(L,0,L.length-1);
    }

    public static void quicksort(int[]L,int left,int right){
	if(right-left>=2){	   
	    int k=partition(L,left,right);
	    quicksort(L,left,k-1);
	    quicksort(L,k+1,right);
	}
    }

    public static int quickselect(int[] L, int k){
	return quickselect(L,k,0,L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right){
	int pivotIndex=partition(L,left,right);
	if(pivotIndex==k)
	    return L[k];
	else if(pivotIndex<k)
	    return quickselect(L,k,left,pivotIndex-1);
	return quickselect(L,k,pivotIndex+1,right);
    }



    public static int partition(int[] L, int left, int right){
	int frontIndex=left, temp=0, pivotInitialIndex=left+rand.nextInt(right-left), pivotNum=L[pivotInitialIndex];
	temp=pivotNum;
	L[pivotInitialIndex]=L[right];
	L[right]=temp;
	for(int i=left;i<right;i++){
	    if(L[i]<=pivotNum){
	    	temp=L[frontIndex];
	    	L[frontIndex]=L[i];
	    	L[i]=temp;
	    	frontIndex++;
	    }
	}
	temp=L[frontIndex];
	L[frontIndex]=L[right];
	L[right]=temp;
	return frontIndex;
    }

    public static void main(String[] args){
	int[] a = {7,2,7,9,4,7,7,3,11,44,1,45,7,666,33,9,4,2,2,6,2,8,8888,8,4,2};
	// int pos=partition(a,0,a.length-1);
	// System.out.println(pos);
	// System.out.println(Arrays.toString(a));
	System.out.println(quickselect(a,6));
   }

}

