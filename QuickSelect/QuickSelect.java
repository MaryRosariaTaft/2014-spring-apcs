import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

    private static Random rand = new Random();

    //this works
    public static void quicksort(int[]L){
	quicksort(L,0,L.length-1);
    }

    public static void quicksort(int[]L,int left,int right){
	//don't run if length is 0 or 1
	if(right-left>=2){	   
	    int pivotIndex=partition(L,left,right);
	    quicksort(L,left,pivotIndex-1);
	    quicksort(L,pivotIndex+1,right);
	}
    }

    //this doesn't work
    public static int quickselect(int[] L, int k){
	return quickselect(L,k,0,L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right){
	//length of portion is 1
	if(left==right)
	    return L[left];
	//partition and get index
	int pivotIndex=partition(L,left,right);
	//found kth element
	if(pivotIndex==k)
	    return L[k];
	//recurse
	else if(pivotIndex<k)
	    return quickselect(L,k,left,pivotIndex-1);
	return quickselect(L,k,pivotIndex+1,right);
    }

    //this works, but not for duplicates
    //if equals pivot, leave alone
    //if smaller, beginning
    //if bigger, at end
    //return middle pivot
    //[0,1,1,1,(1),1,1,1,1,7,8]

    public static int partition(int[] L, int left, int right){
    	//random partition number
    	int frontIndex=left, backIndex=right, temp=0, pivotInitialIndex=left+rand.nextInt(right-left), pivotNum=L[pivotInitialIndex];
    	//store the pivot at end
    	temp=pivotNum;
    	L[pivotInitialIndex]=L[backIndex];
    	L[backIndex]=temp;
	backIndex--;
    	//push elements greater than pivotNum to the right
    	for(int i=left;i<right;i++){
    	    if(L[i]<pivotNum){
    	    	temp=L[frontIndex];
    	    	L[frontIndex]=L[i];
    	    	L[i]=temp;
    	    	frontIndex++;
    	    }else if(L[i]==pivotNum){
		temp=L[backIndex];
		L[backIndex]=L[i];
		L[i]=temp;
		backIndex--;
	    }
    	}
    	//put the pivot(s) back where it(/they) belongs
	// for(int i=backIndex+1;i<=right;i++){
	//     temp=L[frontIndex];
	//     L[frontIndex]=L[i];
	//     L[i]=temp;
	//     frontIndex++;
	// }


    	temp=L[frontIndex];
    	L[frontIndex]=L[right];
    	L[right]=temp;
    	return frontIndex;
    }


    // public static int partition(int[] L, int left, int right){
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

    public static void main(String[] args){
	int[] a = {2,2,2,2,2,2,2,1,2,2,2,2,2,3,2,2};  //{7,2,7,9,4,7,7,3,11,44,1,45,7,666,33,9,4,6,2,8,8888,8,4,2};
	System.out.println("Original array: "+Arrays.toString(a));
	int pos=partition(a,0,a.length-1);
	System.out.println("Pivot index: "+pos);
	System.out.println("Partitioned array: "+Arrays.toString(a));

	// System.out.println("6th smallest element of array: "+quickselect(a,6));

	// quicksort(a);
	// System.out.println(Arrays.toString(a));
   }

}

