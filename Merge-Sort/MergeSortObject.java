import java.io.*;
import java.util.*;

public class MergeSortObject{

    public static <Object extends Comparable<Object>> void msort(ArrayList<Object> L){
             if(L.size()>1){
	   ArrayList<Object> a=new ArrayList<String>(), b=new ArrayList<Object>();
	   copy(L,0,L.size()/2,a);
	   copy(L,a.size(),L.size(),b);
	   msort(a);
	   msort(b);
	   copy(merge(a,b),0,L.size(),L);
	     }
  }

    public static void copy(ArrayList<Object> originalList, int start, int end, ArrayList<Object> newList){
	if(newList.size()>0)
	    newList.clear();
	for(int i=start;i<end;i++)
	    newList.add(originalList.get(i));	    
    }

        public static ArrayList<Object> merge(ArrayList<Object> a, ArrayList<Object> b){
    	ArrayList<Object> ans = new ArrayList<Object>();
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
