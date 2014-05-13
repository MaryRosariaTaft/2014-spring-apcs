public class Heap{//RunningMedian

    private int[] min, max;
    private boolean isMax;

    public Heap(int[] a){
	this.a=a;
    }

    public void add(int i){
	if(i>median){
	    //insert in max heap
	}else{
	    //min heap
	}
    }

    public boolean remove(int i){

    }

    public double median(){
	if(min[0]>max[0])
	    return min[1];
	return (min[1]+max[1])/2;
    }

    public void pushUp(){

    }

    public void pushDown(){

    }

}
