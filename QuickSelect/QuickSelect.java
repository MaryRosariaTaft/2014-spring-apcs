import java.io.*;
import java.util.*;

//runtime: n+(n/2)+(n/4)+(n/8)+... = n+n = 2n = O(n)

public class QuickSelect{

    private static Random rand = new Random();

    public static int quickselect(int[] L, int k){
	//(optionally) send quickselect(int[],int,int,int) a COPY of L instead of original to save the original array
	return quickselect(L,k,0,L.length-1);
    }

    public static int quickselect(int[] L, int k, int left, int right){
	//call partition
	//if pivotIndex==k, return
	//else call quickselect on left OR right side
	return 0;//temp
    }

    /*

9,5,(7),11,2,0,14,676,4,77,12,2,4

temp=last/first;
last/first=L[i];
L[i]=temp;

     */

    public static int partition(int[] L, int left, int right){
	//select pivot index in here: random num btwn left and right
	//changes L
	//returns partition index
	int pivotNum = left + rand.nextInt(right-left), frontIndex=left, backIndex=right, temp;
	for(int i=left;i<right;i++){
	    if(L[i]<=pivotNum){
		temp=L[frontIndex];
		L[frontIndex]=L[i];
		L[i]=temp;
		frontIndex++;
	    }else{
		temp=L[backIndex];
		L[backIndex]=L[i];
		L[i]=temp;
		backIndex--;
	    }
	}
	return backIndex;
    }

    public static void main(String[] args){
	int[] a = {8,3,7,12,65,7,33,9,26,542,7,123,0,6};
	System.out.println(partition(a,0,7)); //6th element (from 0 - infinity) of a
    }

}