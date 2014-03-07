import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[]args){
        try{	    
	    int size = Integer.parseInt(args[0]);
	    Knight t=new Knight(size);	    
	    t.solve();
	    System.out.println();
	    System.out.println(t);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Correct usage:\njava Driver n\n where n is a positive integer.");
        }
    }

}
