public class BinarySearchTree{

    protected class Node{

	private int data, count;
	private Node left, right;

	public Node(){
	    data=0;
	    count=1;
	    left=null;
	    right=null;
	}

	public Node(int d){
	    data=d;
	    count=1;
	    left=null;
	    right=null;
	}

	public void setCount(int count){
	    this.count=count;
	}

	public void setData(int data){
	    this.data=data;
	}

	public void setLeft(Node left){
	    this.left=left;
	}

	public void setRight(Node right){
	    this.right=right;
	}

	public void increment(){
	    count++;
	}

	public void decrement(){
	    count--;
	}

	public int getCount(){
	    return count;
	}

	public int getData(){
	    return data;
	}

	public Node getLeft(){
	    return left;
	}

	public Node getRight(){
	    return right;
	}

	public String toString(){
	    return data+"";
	}

    }

    private Node root;

    //INCOMPLETE
    public int size(){ //number of Nodes in tree
	return 0;        
    }

    public Node find(int target){
	return find(root,target);
    }

    public Node find(Node current, int target){
	if(current==null || target==current.getData()){
	    return current;
	}else{
	    if(target<current.getData()){
		return find(current.getLeft(),target);
	    }else{
		return find(current.getRight(),target);
	    }
	}
    }

    public void insert(int value){
	if(root==null)
	    root=new Node(value);
	else
	    insert(root,value);
    }

    public void insert(Node current, int value){
	if(value<current.getData()&&current.getLeft()==null){
	    current.setLeft(new Node(value));
	}else if(value>current.getData()&&current.getRight()==null){
	    current.setRight(new Node(value));
	}else if(value<current.getData()){
	    insert(current.getLeft(),value);
	}else if(value>current.getData()){
	    insert(current.getRight(),value);
	}else if(value==current.getData()){
	    current.increment();
	}
    }

    public Node highest(){
	if(root==null)
	    return null;
	return highestInBranch(root);
    }

    public Node highestInBranch(Node n){
	if(n.getRight()==null)
	    return n;
	return highestInBranch(n.getRight());
    }

    public Node lowest(){
	if(root==null)
	    return null;
	return lowestInBranch(root);
    }

    public Node lowestInBranch(Node n){
	if(n.getLeft()==null)
	    return n;
	return lowestInBranch(n.getLeft());
    }

    // n is the node to be removed
    // if (n.getRight()==null && n.getLeft()==null); i.e., if n is a leaf
    // set n's parent's right OR left (depending) to null
    // else
    // replace (set) removed value with highest value in branch (data AND count)
    // run remove on the node from which that highest value was taken
    // (this way, 'root' always points to the correct node; properties of nodes are changed, not the nodes themselves)

    public boolean remove(int target){
    	Node n=find(target);
    	if(n==null)
    	    return false;
    	n.decrement();
    	//if the Node is now empty and its value must be removed
    	if(n.getCount()==0){
    	    //if the Node is a leaf
    	    if(n.getRight()==null&&n.getLeft()==null){
    		Node parent=findParent(n);
    		if(n.getData()<parent.getData())
    		    parent.setLeft(null);
    		else if(n.getData()>parent.getData())
    		    parent.setRight(null);
    	    }else{ //if the Node has a child or children
    		//'hi' is the value which is going to replace the value being removed
    		Node hi=highestInBranch(n);
    		if(n==hi)
    		    hi=highestInBranch(n.getLeft());
    		//save the data and count of the Node whose values will replace the removed one
    	        int d=hi.getData();
    		int c=hi.getCount();
    		//remove the Node whose values were just saved
    		remove(hi.getData());
		//finally, remove the values of the Node 'n' and replace them with the saved values
		n.setData(d);
		n.setCount(c);
    	    }
    	}
    	return true;
    }

    public Node findParent(Node n){
	return findParent(root,n);
    }

    public Node findParent(Node current, Node n){
	if(n.getData()<current.getData()){
	    if(current.getLeft()==n)
		return n;
	    return findParent(current.getLeft());
	}else{
	    if(current.getRight()==n)
		return n;
	    return findParent(current.getRight());
	}
    }

    public String list(){
	return list(root);
    }

    public String list(Node current){ //returns an ordered list of the elements in this BinarySearchTree
	return list(current.getLeft())+current+list(current.getRight());
    }

    public String display(){
	return display(root);
    }

    public String display(Node current){
	if(current.getLeft()==null&&current.getRight()==null)
	    return " <--"+current+"--> ";
	if(current.getLeft()==null)
	    return " <--"+current+"-->"+current.getRight()+"\n"+display(current.getRight());
	if(current.getRight()==null)
	    return current.getLeft()+"<--"+current+"--> \n"+display(current.getLeft());
	return current.getLeft()+"<--"+current+"-->"+current.getRight()+
	    "\n"+display(current.getLeft())+"\n"+display(current.getRight());
    }

    public String toString(){
	return display();
    }

}
