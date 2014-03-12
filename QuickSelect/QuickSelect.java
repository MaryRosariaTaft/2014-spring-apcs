import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

    private static Random rand = new Random();

    public static int quickselect(int[] L, int k){
	//optional: send quickselect(int[],int,int,int) a COPY of L instead of original to save the original array
	return quickselect(L,k,0,L.length-1);
    }

    //partition the array based on a randomly selected number
    //if pivotIndex==k, return element of L at that index
    //otherwise call quickselect on left OR right side, based on k's relation to pivotIndex
    //RETURN THE Kth SMALLEST ELEMENT
    //PIVOT INDEX SHOULD BE THE INDEX OF THE SMALLEST ELEMENT AFTER RECURSION
    //UNTIL THEN, 
    public static int quickselect(int[] L, int k, int left, int right){//both boundaries inclusive
	int pivotIndex=partition(L,left,right);
	if(k==pivotIndex)
	    return L[pivotIndex];
	if(k<pivotIndex)
	    return quickselect(L,k,left,pivotIndex);
	else
	    return quickselect(L,k,pivotIndex+1,right);
    }

    public static int partition(int[] L, int left, int right){
	int pivotNum = L[left+right/2], frontIndex=left, backIndex=right, temp=0;
	// for(int i=left;i<=right;i++){
	//     //separate off elements equal to the pivotNum to avoid duplicate issues--just an optimization
	//     if(L[i]<=pivotNum){//so, the pivotNum will reside on the left partitioned piece of the array
	// 	temp=L[frontIndex];
	// 	L[frontIndex]=L[i];
	// 	L[i]=temp;
	// 	frontIndex++;
	//     }else{
	// 	temp=L[backIndex];
	// 	L[backIndex]=L[i];
	// 	L[i]=temp;
	// 	backIndex--;
	//     }
	// }

	int[] tempArray=new int[L.length];
	int front=left,back=right;
	for(int i=left;i<=right;i++){
	    if(L[i]<=pivotNum){
		tempArray[front]=L[i];
		front++;
	    }else{
		tempArray[back]=L[i];
		back--;
	    }
	}
	L=tempArray;

	//System.out.println("Pivot number: "+pivotNum);
	return back;
	//RETURNS THE INDEX OF THE PIVOT POINT
	//IF IT'S 
    }

    public static void main(String[] args){
	int[] a = {8,3,7,12,65,7,33,9,26,542, 7,123, 0, 6};
	//         0 1 2  3  4 5  6 7  8   9 10  11 12 13
	// 0,3,6,7,7,7,8,9,12,26,33,65,123,542
	// 0 1 2 3 4 5 6 7  8  9 10 11  12  13
	// System.out.println("Pivot number's index: "+partition(a,0,a.length-1));
	// System.out.println("\n"+Arrays.toString(a));
	System.out.println(quickselect(a,13));
   }

}
