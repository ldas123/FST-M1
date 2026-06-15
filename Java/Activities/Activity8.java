package activities;
import java.util.*;

public class Activity8 {

	public static void main(String[] args) {
		
		//Create an ArrayList named myList of type String
		List<String> myList = new ArrayList();
		
		//Add 5 names to the ArrayList using add() method
		myList.add("Kabir");
		myList.add("Rahul");
		myList.add("Raju");
		myList.add("Raj");
		myList.add("Laxmi");
		
		// Then print all the names using for loop
		for(String str:myList) {
			System.out.println(str);
		}
		
		// Then use get() method to retrieve the 3rd name in the ArrayList
		System.out.println(myList.get(2));
		
		// Use contains() method to check if a name exists in the ArrayList
		System.out.println("Is Raj exists: "+myList.contains("Raj"));
		
		// Use size() method to print the number of names in the ArrayList
		System.out.println("number of names: "+myList.size());
		
		// Use remove() method to remove a name from the list and print the size() of the list again
		myList.remove(4);
		System.out.println("Size of list after removing a name: "+myList.size());

	}

}
