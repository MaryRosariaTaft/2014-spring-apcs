import java.util.*;

public class SpeedTest{

    public static void main(String[] args){

	Random r=new Random();

	TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
	TreeSet<Integer> ts=new TreeSet<Integer>();
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	HashSet<Integer> hs=new HashSet<Integer>();

	double t1=0,t2=0;//Java compiler...

	t1=System.currentTimeMillis();
	for(int i=0;i<5000000;i++){
	    tm.put(i,r.nextInt(10000));
	}
	t2=System.currentTimeMillis();
	System.out.println("TreeMap's put(): "+(t2-t1));

	t1=System.currentTimeMillis();
	for(int i=0;i<5000000;i++){
	    ts.add(r.nextInt(10000));
	}
	t2=System.currentTimeMillis();
	System.out.println("TreeSet's add(): "+(t2-t1));

	t1=System.currentTimeMillis();
	for(int i=0;i<5000000;i++){
	    hm.put(i,r.nextInt(10000));
	}
	t2=System.currentTimeMillis();
	System.out.println("HashMap's put(): "+(t2-t1));

	t1=System.currentTimeMillis();
	for(int i=0;i<5000000;i++){
	    hs.add(r.nextInt(10000));
	}
	t2=System.currentTimeMillis();
	System.out.println("HashSet's add(): "+(t2-t1));

    }

}