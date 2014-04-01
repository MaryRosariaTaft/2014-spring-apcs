public class Driver {

    public static void main(String[] args){
	DoubleLL<String> L=new DoubleLL<String>();
	System.out.println(L);
	L.insertAfter("hello");
	System.out.println(L);
	L.insertAfter("world");
	System.out.println(L);
	L.insertAfter("three");
	System.out.println(L);
	System.out.println(L.getCurrent());
	L.back();
	System.out.println(L.getCurrent());
	L.insertAfter("inserted");
	System.out.println(L);
    }

}
