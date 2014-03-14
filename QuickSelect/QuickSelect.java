import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

    private static Random rand = new Random();

    public static int quickselect(int[] L, int k){
	return quickselect(L,k,0,L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right){//both boundaries inclusive //overloading
	int pivotIndex=partition(L,left,right);
	if(pivotIndex==k)
	    return L[k];
	else if(pivotIndex<k)
	    return quickselect(L,k,left,pivotIndex-1);
	return quickselect(L,k,pivotIndex+1,right);
    }



    public static int partition(int[] L, int left, int right){

	//Non-destructive
	//Apparently doesn't work
	//separate off elements equal to the pivotNum to avoid duplicate issues--just an optimization
	int frontIndex=left, backIndex=right, temp=0, pivotInitialIndex=frontIndex+rand.nextInt(backIndex-frontIndex), pivotNum=L[pivotInitialIndex];
	temp=pivotNum;
	L[pivotInitialIndex]=L[backIndex];
	L[backIndex]=temp;
	backIndex--;
	for(int i=left;i<right;i++){
	    if(L[i]<=pivotNum){//so, the pivotNum will reside on the left partitioned piece of the array
		// temp=L[frontIndex];
		// L[frontIndex]=L[i];
		// L[i]=temp;
		frontIndex++;
	    }else{
		temp=L[backIndex];
		L[backIndex]=L[i];
		L[i]=temp;
		backIndex--;
	    }
	}
	temp=L[frontIndex];
	L[frontIndex]=L[right];
	L[right]=temp;
	return frontIndex;
	
	//throw the pivotNum value at the front or back
	//try swapping instead
	//middle is reached when front==back

	// int ans[]=new int[L.length];
	// int front=left,back=right,pivot=L[front+rand.nextInt(back-front)];//apparently the index comes out to be negative...
	// for(int i=left;i<right;i++){
	//     if(L[i]<=pivot){
	// 	ans[front]=L[i];
	// 	front++;
	//     }else{
	// 	ans[back]=L[i];
	// 	back--;
	//     }
	// }
	// L=ans;
	// return front;//last index of the first (smaller) half

    }

    public static void main(String[] args){
	int[] a = {9,8,7,6,5,4,3,2,1,0};
	System.out.println("Original array: "+Arrays.toString(a));
	System.out.println("Partition index: "+partition(a,0,a.length-1));
	System.out.println("Partitid array: "+Arrays.toString(a));
	// System.out.println(quickselect(a,6));
   }

}


//quick sort
//get rid of base case
//new base case: if (right-left)<2
//get rid of k
