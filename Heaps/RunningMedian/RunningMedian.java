public class RunningMedian{

    private int[] max, min; //roots of each: max of the smaller half, min of the larger half
    private int maxSize, minSize;

    public RunningMedian(){
	max=new int[1000];
	min=new int[1000];
	maxSize=0;
	minSize=0;
    }

    public int[] getMax(){
	return max;
    }

    public int[] getMin(){
	return min;
    }

    public int maxSize(){
	return maxSize;
    }

    public int minSize(){
	return minSize;
    }

    public void grow(){
	int[] temp=new int[max.length*2];
	for(int i=0;i<maxSize;i++){
	    temp[i]=max[i];
	}
	max=temp;
	int[] temp1=new int[min.length*2];
	for(int i=0;i<minSize;i++){
	    temp[i]=min[i];
	}
	min=temp1;
    }

    public void shrink(){
	int[] temp=new int[max.length/2];
	for(int i=0;i<maxSize;i++){
	    temp[i]=max[i];
	}
	max=temp;
	int[] temp1=new int[min.length/2];
	for(int i=0;i<minSize;i++){
	    temp[i]=min[i];
	}
	min=temp1;
    }

    public void fixSize(){
	//arrays are almost full
	if(maxSize>=max.length-15){
	    grow();
	}
	//arrays are much bigger than the data set they contain
	else if(maxSize<=(max.length)/4){
	    shrink();
	}
    }

    public boolean empty(){
	//left heap (the half with the smaller numbers) has priority in insertion
	return maxSize<=0;
    }

    public void pushUp(int[] a, int index){
	//(index-1)/2 is the index of the given index's parent
	while(a[index]>a[(index-1)/2]){
	    swap(a,index,(index-1)/2);
	    index=(index-1)/2;
	}
    }

    public void pushDown(int[] a, int index, int upperBound){
	//while the index has at least one child (the left child)
	while(index*2+1<upperBound){
	    //assign the child as the left child
	    int child=index*2+1;
	    //make a variable to store which index the given index will potentially be swapped with
	    int swapIndex=index;
	    //if the left child is greater than the parent (the value at the given index)
	    if(a[swapIndex]<a[child])
		swapIndex=child;
	    //if the right child exists
	    if(child+1<upperBound)
		//if it's greater than the left child (since the parent should be swapped with the LARGER of the two children)
	        if(a[swapIndex]<a[child+1])
		    swapIndex=child+1;
	    //swap the value at the given index with the proper child if necessary
	    if(index!=swapIndex){
		swap(a,index,swapIndex);
		index=swapIndex;
	    }
	    //value at index is in the correct place
	    else
		break;
	}
    }

    public void swap(int[] a, int x, int y){
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
    }

    public void removeRoot(int[] a, int upperBound){
	a[0]=a[upperBound-1];
	a[upperBound-1]=0;
	pushDown(a,0,upperBound);
    }

    public void add(int value){

	fixSize();

	//if adding first element
	if(maxSize==0){
	    max[0]=value;
	    maxSize=1;
	    return;
	}
	//if adding second element
	if(minSize==0){
	    min[0]=value;
	    minSize=1;
	    return;
	}
	//else, do all the fancy stuff:

	if(value<=median()){
	    //add to max heap
	    max[maxSize]=value;
	    //push up to right place:
	    pushUp(max,maxSize);
	    //increment maxSize for the following check (rebalancing)
	    maxSize++;
	    //rebalance* if necessary
	    //*rebalance by moving root of max heap into the min heap
	    if(maxSize>minSize+1){
		//move max's root into min
		min[minSize]=max[0];
		pushUp(min,minSize);
		minSize++;
		//reconfigure max heap:
		//(1) move bottom-right leaf to root
		max[0]=max[maxSize-1];
		//(2) remove duplicate value (not necessary since we there's a variable keeping track of the size, but it's nice and clean)
		max[maxSize-1]=0;
		//(3) decrement maxSize
		maxSize--;
		//(4) push down the displaced value into the right spot
		//*max[maxSize] is now unoccupied and is the UPPER BOUND by which child indicies can be checked, since the upperBound parameter in pushdown() is _ex_clusive
		pushDown(max,0,maxSize);
	    }
	}else{//if value>median(), add to min heap, rebalance if necessary
	    //add to min heap
	    min[minSize]=value;
	    //push up to right place:
	    pushUp(min,minSize);
	    //increment...
	    minSize++;
	    //rebalance if necessary
	    if(minSize>maxSize){
		//move min's root into max
		max[maxSize]=min[0];
		pushUp(max,maxSize);
		maxSize++;
		//reconfigure max heap:
		//(1) move bottom-right leaf to root
		min[0]=min[minSize-1];
		//(2) remove duplicate value (not necessary since we there's a variable keeping track of the size, but it's nice and clean)
		min[minSize-1]=0;
		//(3) decrement minSize
		minSize--;
		//(4) push down the displaced value into the right spot
		//*min[minSize] is now unoccupied and is the UPPER BOUND by which child indicies can be checked, since the upperBound parameter in pushdown() is _ex_clusive
		pushDown(min,0,minSize);
	    }
	}

    }

    //removes median(s)
    public double remove(){

	fixSize();

	if(empty()){
	    throw new IllegalStateException();
	}

	double temp=median();
	//remove root from min heap if median is the average of both roots
	if(maxSize==minSize){
	    min[0]=min[minSize-1];
	    min[minSize-1]=0;
	    minSize--;
	    pushDown(min,0,minSize);
	}
	//remove root from max heap no matter what
	max[0]=max[maxSize-1];
	max[maxSize-1]=0;
	maxSize--;
	pushDown(max,0,maxSize);
	return temp;
    }

    //average if sizes are equal, root of max otherwise
    public double median(){
	if(empty()){
	    throw new IllegalStateException();
	}
	if(maxSize==minSize)
	    return (double)(max[0]+min[0])/2;
	return max[0];
    }

}
