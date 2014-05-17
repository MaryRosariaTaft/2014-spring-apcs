public class RunningMedian{

    private int[] max, min; //roots of each: max of the smaller half, min of the larger half
    private int maxSize, minSize;

    public RunningMedian(){
	max=new int[15];
	min=new int[15];
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
	int[] tempMax=new int[max.length*2];
	int[] tempMin=new int[min.length*2];
	for(int i=0;i<max.length;i++){
	    tempMax[i]=max[i];
	    tempMin[i]=min[i];
	}
	max=tempMax;
	min=tempMin;
    }

    public void shrink(){
	int[] tempMax=new int[max.length/2];
	int[] tempMin=new int[min.length/2];
	for(int i=0;i<max.length/2;i++){
	    tempMax[i]=max[i];
	    tempMin[i]=min[i];
	}
	max=tempMax;
	min=tempMin;
    }

    public void fixSize(){
    	//arrays are almost full
    	if(maxSize>=max.length-15){
    	    grow();
    	}
    	//arrays are much bigger than the data set they contain
    	else if(maxSize<=max.length/4&&maxSize>100){
    	    shrink();
    	}
    }

    public boolean empty(){
	//left heap (the half with the smaller numbers) has priority in insertion
	return maxSize<=0;
    }

    public void pushUp(int[] a, int index, String type){
	//(index-1)/2 is the index of the given index's parent
	if(type.equals("max")){
	    while(a[index]>a[(index-1)/2]){
		swap(a,index,(index-1)/2);
		index=(index-1)/2;
	    }
	}else if(type.equals("min")){
	    while(a[index]<a[(index-1)/2]){
		swap(a,index,(index-1)/2);
		index=(index-1)/2;
	    }
	}
    }

	public void pushDown(int[] a, int index, int upperBound, String type){
	    if(type.equals("max")){
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
	    }else if(type.equals("min")){
		//while the index has at least one child (the left child)
		while(index*2+1<upperBound){
		    //assign the child as the left child
		    int child=index*2+1;
		    //make a variable to store which index the given index will potentially be swapped with
		    int swapIndex=index;
		    //if the left child is greater than the parent (the value at the given index)
		    if(a[swapIndex]>a[child])
			swapIndex=child;
		    //if the right child exists
		    if(child+1<upperBound)
			//if it's greater than the left child (since the parent should be swapped with the LARGER of the two children)
			if(a[swapIndex]>a[child+1])
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
	}

	public void swap(int[] a, int x, int y){
	    int temp=a[x];
	    a[x]=a[y];
	    a[y]=temp;
	}

	public void removeRoot(int[] a, int upperBound, String type){
	    //move bottom-right leaf to root position
	    a[0]=a[upperBound-1];
	    //clear out bottom-right (for cleanness)
	    a[upperBound-1]=0;
	    //push down the displaced value into its correct position
	    pushDown(a,0,upperBound-1,type);
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
		pushUp(max,maxSize,"max");
		//increment maxSize for the following check (rebalancing)
		maxSize++;
		//rebalance* if necessary
		//*rebalance by moving root of max heap into the min heap
		if(maxSize>minSize+1){
		    //move max's root into min
		    min[minSize]=max[0];
		    pushUp(min,minSize,"min");
		    minSize++;
		    //reconfigure max heap
		    removeRoot(max,maxSize,"max");
		    maxSize--;
		}
	    }else{//if value>median()
		//add to min heap
		min[minSize]=value;
		//push up to right place:
		pushUp(min,minSize,"min");
		//increment...
		minSize++;
		//rebalance if necessary
		if(minSize>maxSize){
		    //move min's root into max
		    max[maxSize]=min[0];
		    pushUp(max,maxSize,"max");
		    maxSize++;
		    //reconfigure min heap
		    removeRoot(min,minSize,"min");
		    minSize--;
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
		removeRoot(min,minSize,"min");
		minSize--;
	    }
	    //remove root from max heap no matter what
	    removeRoot(max,maxSize,"max");
	    maxSize--;
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

    public String toString(){
	String ans="";
	ans+="Max Heap: [";
	for(int i=0;i<maxSize;i++){
	    if(i==maxSize-1)
		ans+=max[i];
	    else
		ans+=max[i]+",";
	}
	ans+="]\n";
	ans+="Min Heap: [";
	for(int i=0;i<minSize;i++){
	    if(i==minSize-1)
		ans+=min[i];
	    else
		ans+=min[i]+",";
	}
        ans+="]\n";
	return ans;
    }

}
