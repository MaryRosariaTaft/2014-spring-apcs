public class Driver {

    public static void main(String[] args){
	CircleLL<String> L=new CircleLL<String>();
	System.out.println(L);
	System.out.println("List: "+L);
	System.out.println("Current: "+L.getCurrent());
	System.out.println("Adding before current.");
	L.insertBefore("hello");
	System.out.println("List: "+L);
	System.out.println("Current: "+L.getCurrent());
	System.out.println("Adding before current.");
	L.insertBefore("world");
	System.out.println("List: "+L);
	System.out.println("Current: "+L.getCurrent());
	System.out.println("Adding before current.");
	L.insertBefore("three");
	System.out.println("List: "+L);
	System.out.println("Current: "+L.getCurrent());
	L.back();
	System.out.println("Moved back one.");
	System.out.println("Current: "+L.getCurrent());
	System.out.println("Adding after current.");
	L.insertAfter("inserted");
	System.out.println("Current: "+L.getCurrent());
	System.out.println("List: "+L);
    }

}
