package activities;

import java.util.*;

public class Activity9 {

	public static void main(String[] args) {
		
		// Create a HashSet named hs
		HashSet<Object> hs = new HashSet();
		
		// Add 6 objects using add() method to the HashSet
		hs.add("Sanu");
		hs.add("Rahul");
		hs.add("Laxmi");
		hs.add("Sandeep");
		hs.add("Kunal");
		
		System.out.println("Original HashSet: "+hs);
		
		// Then print the size of the HashSet using the size() method
		System.out.println("Size of hashset: "+hs.size());
		
		// Remove an element using the remove() method
		hs.remove("Kunal");
		
		// Also try to remove an element that is not present in the Set
		hs.remove("kunal");
		
		// Use the contains() method to check if an item is in the Set or not
		System.out.println("is Laxmi present in hashset: "+hs.contains("Laxmi"));
		
		// Print the updated set
		System.out.println("Updated HashSet: "+hs);

	}

}
