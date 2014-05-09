public class HeapSort{

    public static void heapsort(int[] a){
	heapify(a);
	//swap max to end of heap
	//push down displaced value by swapping with children until it's in the correct place
	
    }

    public static void heapify(int[] a){
	for(int i=0;i<a.length;i++){
	    //push up children if they're bigger than their parents
	    //gahh this should be in a while loop
	    if(a[i]>a[parentIndex])
		pushUp(i);
	}
    }

    public static int parentIndex(int index){
	return (index-1)/2;
    }

    public static int childIndex(int index, int[] a){
	//index has no children
	if(2*index+1>=a.length)
	    return index;
	//index has only 1 child, the left one
	if(2*index+2>=a.length)
	    return 2*index+1;
	//index has 2 children; return the preferred right one (since heaps fill in each layer in trees, left to right, before they move on to the next one)
	return 2*index+2;
    }

    public static void pushUp(int[] a, int index){
	swap(a,index,parentIndex(index));
    }

    public static void pushDown(int[] a, int index){
	swap(a,index,childIndex(index));
    }    

    public static void swap(int[] a, int x, int y){
	temp=a[x];
	a[x]=a[y];
	a[y]=temp;
    }

}