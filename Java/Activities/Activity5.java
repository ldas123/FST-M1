package activities;

public class Activity5 {

	public static void main(String[] args) {
		// Initialize title of the book
		String title = "Harry Potter";
		// Create object for MyBook
		MyBook newNovel = new MyBook();
		// Set title
		newNovel.setTitle(title);
		
		// Print result
		System.out.println("The title is: " + newNovel.getTitle());

	}

}
