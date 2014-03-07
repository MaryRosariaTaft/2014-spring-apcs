import java.io.*;
import java.util.*;
public class Recursion{

    public int hailLen(int n){
	if(n<1)
	    return -1;
	if(n==1)
	    return 1;
	else {
	    if(n%2==0)
		return 1+hailLen(n/2);
	    return 1+hailLen(3*n+1);
	}
    }

    public int longestHail(int n){
	if(n<0)
	    return -1;
	if(n<=1)
	    return n;
	//return Math.max(hailLen(n),longestHail(n-1));
	return longestHailHelper(n,n-1,n);
    }

    public int longestHailHelper(int a,int b,int c){
	if(b==1)
	    return c;
	if(hailLen(a)>=hailLen(b)&&hailLen(a)>=hailLen(c))
	    return longestHailHelper(a-1,b-1,a);
	if(hailLen(b)>=hailLen(a)&&hailLen(b)>=hailLen(c))
	    return longestHailHelper(a-1,b-1,b);
	return longestHailHelper(a-1,b-1,c);
    }

    public int fibItr(int n){
	if(n<0)
	    return -1;
	if(n<=1)
	    return n;
	return fibHelper(0,1,n-2);
    }
    public int fibHelper(int a,int b,int c){
	if(c==0)
	    return a+b;
	return fibHelper(b,a+b,c-1);
    }
}

// public class temp {

//     public static int hail(int n) {
// 	System.out.println(n);
// 	if(n<1)
// 	    return -1;
// 	if(n%2==0)
// 	    return hail(n/2);
// 	else {
// 	    if(n!=1)
// 		return hail(3*n+1);
// 	    return 1;
// 	}
//     }

//     public static int hailLen(int n) {
// 	if(n<1)
// 	    return -1;
// 	if(n==1)
// 	    return n+1;
// 	else {
// 	    if(n%2==0)
// 		return 1+hailLen(n/2);
// 	    return 1+hailLen(3*n+1);
// 	}
//     }

//     public static int longestHail(int n) {
//     	if(n<1)
//     	    return -1;
//     	if(n==1)
//     	    return 1;
//     	else{
//     	    if(hailLen(n)>longestHail(n-1))
//     		return n;
// 	    return longestHail(n-1);
//     	}
//     }

//     public static void main (String[] args) {
// 	System.out.println(hail(1));
// 	System.out.println(hailLen(1));
// 	System.out.println(longestHail(1));
// 	System.out.println();
// 	System.out.println(hail(2));
// 	System.out.println(hailLen(2));
// 	System.out.println(longestHail(2));
// 	System.out.println();
// 	System.out.println(hail(3));
// 	System.out.println(hailLen(3));
// 	System.out.println(longestHail(3));
// 	System.out.println();
// 	System.out.println(hail(4));
// 	System.out.println(hailLen(4));
// 	System.out.println(longestHail(4));
// 	System.out.println();
// 	System.out.println(hail(5));
// 	System.out.println(hailLen(5));
// 	System.out.println(longestHail(5));
// 	System.out.println();
// 	System.out.println(hail(6));
// 	System.out.println(hailLen(6));
// 	System.out.println(longestHail(6));
// 	System.out.println();
// 	System.out.println();
// 	System.out.println(hail(7));
// 	System.out.println(hailLen(7));
// 	System.out.println(longestHail(7));
// 	System.out.println();
// 	System.out.println();
// 	System.out.println(hail(8));
// 	System.out.println(hailLen(8));
// 	System.out.println(longestHail(8));
// 	System.out.println();
//     }

// }
