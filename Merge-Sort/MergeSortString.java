import java.io.*;
import java.util.*;

public class MergeSortString{

    public static String name(){
        /****************EDIT YOUR NAME HERE:****************/
        return "Taft,Mary";
    }

  public static void msort(ArrayList<String> L){ 
    /************************YOUR SORT HERE****************/
             if(L.size()>1){
	   ArrayList<String> a=new ArrayList<String>(), b=new ArrayList<String>();
	   copy(L,0,L.size()/2,a);
	   copy(L,a.size(),L.size(),b);
	   msort(a);
	   msort(b);
	   copy(merge(a,b),0,L.size(),L);
	     }
  }

    public static void copy(ArrayList<String> originalList, int start, int end, ArrayList<String> newList){
	if(newList.size()>0)
	    newList.clear();
	for(int i=start;i<end;i++)
	    newList.add(originalList.get(i));	    
    }

        public static ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b){
    	ArrayList<String> ans = new ArrayList<String>();
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

    // public static void main(String[] args){
    // 	ArrayList<String> l=new ArrayList<String>();
    // 	l.add("dog");
    // 	l.add("test");
    // 	l.add("a");
    // 	l.add("cat");
    // 	l.add("capitals");
    // 	l.add("REPLACEMENTS");
    // 	l.add("cat");
    // 	l.add("even");
    // 	l.add(" space");
    // 	msort(l);
    // 	System.out.println(l);
    // }

}
