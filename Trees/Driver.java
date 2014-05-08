public class Driver{

    public static void main(String[] args){
	BinarySearchTree fred = new BinarySearchTree();
	fred.insert(50);
	fred.insert(25);
	fred.insert(75);
	fred.insert(12);
	fred.insert(37);
	fred.insert(87);
	fred.insert(63);
	System.out.println(fred);
	fred.remove(75);
	System.out.println();
	System.out.println(fred);
	fred.remove(87);
	System.out.println();
	System.out.println(fred);

	// These all work:
	// System.out.println(fred.lowest());
	// System.out.println(fred.find(12));
	// System.out.println(fred.findParent(fred.find(12)));
	// System.out.println(fred.findParent(fred.find(12)).getLeft());
    }


}
