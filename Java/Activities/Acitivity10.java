package activities;

import java.util.*;

public class Acitivity10 {

	public static void main(String[] args) {
		
		// Create a Map named colours with integer keys and String values
		Map<Integer,String> colours = new HashMap();
		
		// Add 5 random colours to it and print the Map to the console
		colours.put(1,"Orange");
		colours.put(2,"Green");
		colours.put(3,"Red");
		colours.put(4,"Voilate");
		colours.put(5,"White");
		
		System.out.println("Map is: "+colours);
		
		// Remove one colour using the remove() method
		colours.remove(3);
		
		// Check if the colour green exists in the Map using the containsValue() method
		System.out.println("Is Green exists: "+colours.containsValue("Green"));
		
		// Print the size of the Map using the size() method
		System.out.println("Size of Map is: "+colours.size());

	}

}
