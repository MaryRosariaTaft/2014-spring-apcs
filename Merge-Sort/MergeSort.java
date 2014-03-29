import java.io.*;
import java.util.*;

public class MergeSort{

    public static <T extends Comparable<T>> void msort(ArrayList<T> L){
	if(L.size()>1){
	    ArrayList<T> a=new ArrayList<T>(), b=new ArrayList<T>();
	    copy(L,0,L.size()/2,a);
	    copy(L,a.size(),L.size(),b);
	    msort(a);
	    msort(b);
	    copy(merge(a,b),0,L.size(),L);
	}
    }

    public static <T extends Comparable<T>> void copy(ArrayList<T> originalList, int start, int end, ArrayList<T> newList){
	if(newList.size()>0)
	    newList.clear();
	for(int i=start;i<end;i++)
	    newList.add(originalList.get(i));	    
    }

    public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> a, ArrayList<T> b){
    	ArrayList<T> ans = new ArrayList<T>();
    	while(a.size()>0||b.size()>0){
    	    if(a.size()==0){
    		ans.add(b.remove(0));
    	    }else if(b.size()==0){
    		ans.add(a.remove(0));
    	    }else{
    		if(a.get(0).compareTo(b.get(0))<0){
    		    ans.add(a.remove(0));
    		}else{
    		    ans.add(b.remove(0));
    		}
    	    }
    	}
    	return ans;
    }

    public static void main(String[]args){
	ArrayList<Person> L= new ArrayList<Person>();
	L.add(new Person("Ben"));
	L.add(new Person("Dave"));
	L.add(new Person("Amy"));
	L.add(new Person("Liz"));
	L.add(new Person("Portnoy"));
	L.add(new Person("Wolf"));
	L.add(new Person("Zed"));
	L.add(new Person("Xin"));
	L.add(new Person("Smith"));
	L.add(new Person("Will"));
	L.add(new Person("Ed"));
	L.add(new Person("Eddie"));
	L.add(new Person("Aaron"));
	L.add(new Person("Cary"));
	msort(L);
	System.out.println(L);
    }

}
