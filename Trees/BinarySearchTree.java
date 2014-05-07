public class BinarySearchTree{

    private class Node{

	private int data, count;
	private Node left, right;

	public Node(){
	    data=0;
	    count=1;
	    left=null;
	    right=null;
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

    public BinarySearchTree(){
	root=null;
	root.setData(0);
	root.setRight(null);
	root.setLeft(null);
    }

    public Node find(int target){
	current=root;
	while(current!=null){
	    if(target==current.getData())
		return current;
	    if (target<current.getData())
		current=current.getLeft();
	    else if (target>current.getData())
		current=current.getRight();
	}
	return null;
    }

    public void insert(int value){
	Node alreadyThere = find(value);
	if (alreadyThere!=null)
	    alreadyThere++;
	return;

	current=root;
	while(current!=null){
	    //there isn't one --> move down through children
	    if (value<current.getData())
		current=current.getLeft();
	    else if (value>current.getData())
		current=current.setRight(newNode);
	}
	if(value<current.getData())
	    current.setLeft(newNode);
	else
	    current.setRight(newNode);
    }


    public boolean remove(int target){
	current=find(target);
	//base case: removing a leaf
	//take into accoutn removing branches, roots, etc.
	//replace
    }

    //fred.insert 2,5,9,-1,-3,1,10
	/*
	  toString
	  recursion
	  if anything == null print ' ' (a space)

	  
	  LEFT SUBTREE BEFORE RIGHT SUBTREE
	  B<A>C
	  B>E
	  E<C>G
	  H<F

	  tree:
      A
   B     C
    E   F G
       H
	*/

    }
