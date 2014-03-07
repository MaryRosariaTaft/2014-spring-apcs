import java.io.*;
import java.util.*;

public class MergeSortInt{

    // Using one method (no "copy"):
    // public static int[] msort1(int[] list){
    // 	if(list.length==1) return list;
    // 	int[] a,b;
    // 	int half=list.length/2;
    // 	a=new int[half];
    // 	if(list.length%2==0) b=new int[half];
    // 	else b=new int[half+1];
    // 	for(int i=0;i<a.length;i++) a[i]=list[i];
    // 	for(int i=half,j=0;j<b.length;i++,j++) b[j]=list[i];
    // 	a=msort1(a);
    // 	b=msort1(b);
    // 	return merge(a,b);
    // }

    public static void msort(int[] list){
	if(list.length>1){
	    int[] a=new int[list.length/2], b=new int[list.length-a.length];
	    copy(list,0,a);
	    copy(list,a.length,b);
	    msort(a);
	    msort(b);
	    copy(merge(a,b),0,list);
	}
    }

    public static void copy(int[] list, int listStart, int[] halfList){
	for(int i=0,j=listStart;i<halfList.length;i++,j++)
	    halfList[i]=list[j];
    }

    public static int[] merge(int[] a, int[] b){
	int[] ans = new int[a.length+b.length];
	int aIndex=0,bIndex=0;
	for(int i=0;i<ans.length;i++){
	    if(aIndex==a.length){
		ans[i]=b[bIndex];
		bIndex++;
	    }else if(bIndex==b.length){
		ans[i]=a[aIndex];
		aIndex++;
	    }else{
		if(a[aIndex]<b[bIndex]){
		    ans[i]=a[aIndex];
		    aIndex++;
		}else{
		    ans[i]=b[bIndex];
		    bIndex++;
		}
	    }
	}
	return ans;
    }

    // public static void main(String[] args){
    // 	int[] intTest = {3,1,9,14,77,3,14,76,84,3,1,1,1,24,3};
    // 	msort(intTest);
    // 	for(int i=0;i<intTest.length;i++)
    // 	    System.out.println(intTest[i]);
    // }

}
