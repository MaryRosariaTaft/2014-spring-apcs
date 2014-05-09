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
	System.out.println("Size: "+fred.size());

	// Checks for consistency:
	// System.out.println();
	// System.out.println("25: "+fred.find(25));
	// System.out.println("50: "+fred.findParent(fred.find(25)));
	// System.out.println("25: "+fred.findParent(fred.find(25)).getLeft());
	// System.out.println("12: "+fred.findParent(fred.find(25)).getLeft().getLeft());

	fred.remove(75);
	System.out.println();
	System.out.println("Removed 75.");
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.remove(87);
	System.out.println();
	System.out.println("Removed 87.");
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.insert(25);
	System.out.println();
	System.out.println("Inserted another 25.");
	System.out.println("Count on Node holding 25: "+fred.find(25).getCount());
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.remove(25);
	System.out.println();
	System.out.println("Removed one of the two 25's.");
	System.out.println("Count on Node holding 25: "+fred.find(25).getCount());
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.remove(50);
	System.out.println();
	System.out.println("Removed root.");
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.remove(63);
	System.out.println();
	System.out.println("Removed root.");
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	fred.remove(37);
	System.out.println();
	System.out.println("Removed root.");
	System.out.println(fred);
	System.out.println("Size: "+fred.size());

	// These all work:
	// System.out.println(fred.lowest());
	// System.out.println(fred.find(12));
	// System.out.println(fred.findParent(fred.find(12)));
	// System.out.println(fred.findParent(fred.find(12)).getLeft());

    }


}
