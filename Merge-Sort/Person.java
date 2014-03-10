public class Person implements Comparable<Person>{

    private String name;

    public Person(String s){
	name=s;
    }

    public String getName(){
	return name;
    }

    public String toString(){
	return name;
    }
   
    public int compareTo(Person other){
	return getName().compareTo(other.getName());
    }

}
