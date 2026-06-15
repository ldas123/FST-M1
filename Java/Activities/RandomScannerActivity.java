package activities;

import java.util.*;

public class RandomScannerActivity {

	public static void main(String[] args) {
		
		// Create a Scanner object named scan
		Scanner scan = new Scanner(System.in);
		
		// Create an ArrayList object named list
		List<Integer> list = new ArrayList();
		
		// Create a Random class object named indexGen
		Random indexGen = new Random();
		
		System.out.print("Enter integers numbers (enter any non-integer letter/word to stop): ");
		
		// Add a scan statement with nextInt() to accept only integer values, inside a loop to accept multiple values
		// Use the hasNextInt() method with the loop to ensure only integer values are accepted.
		
		while(scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		
		// Check if the user actually entered any numbers to prevent errors
		if(list.isEmpty()) {
			System.out.println("No numbers were entered. Exiting program.");
		}else {
			// convert the arraylist into array using toArray()
			Integer nums[] = list.toArray(new Integer[0]);
			
			// Use indexGen to generate an integer value with the bounds set to the length of nums array.
			int index = indexGen.nextInt(nums.length);
			
			// Print the index value that was generated and the value in the array at that index value
			System.out.println("Index value generated: "+index);
			System.out.println("Value at generated index is "+nums[index]);
		}
		scan.close();
	}

}
