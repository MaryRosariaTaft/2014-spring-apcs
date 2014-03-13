import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

    private static Random rand = new Random();

    public static int quickselect(int[] L, int k){
	return quickselect(L,k,0,L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right){//both boundaries inclusive
	int pivotIndex=partition(L,left,right);
	if(pivotIndex==k)
	    return L[k];
	else if(pivotIndex<k)
	    return quickselect(L,k,left,pivotIndex);
	return quickselect(L,k,pivotIndex+1,right);
    }

    public static int partition(int[] L, int left, int right){
	int ans[]=new int[L.length];
	int front=left,back=right,pivot=L[front+back/2];//L[front+rand.nextInt(back-front)];
	for(int i=left;i<right;i++){
	    if(L[i]<=pivot){
		ans[front]=L[i];
		front++;
	    }else{
		ans[back]=L[i];
		back--;
	    }
	}
	L=ans;
	return front;//last index of the first (smaller) half
    }

    public static void main(String[] args){
	//     unsorted array
	int[] a = {8,3,7,12,65,7,33,9,26,542, 7,123, 0, 6};
	//indecies 0 1 2  3  4 5  6 7  8   9 10  11 12 13
	//     sorted array
	//         0,3,6,7,7,7,8,9,12,26,33,65,123,542
	//indecies 0 1 2 3 4 5 6 7  8  9 10 11  12  13
	// System.out.println(partition(a,0,a.length-1));
	// System.out.println("\n"+Arrays.toString(a));
	System.out.println(quickselect(a,13));
   }

}
