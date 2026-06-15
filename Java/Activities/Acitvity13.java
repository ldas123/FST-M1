package activities;

import java.util.*;

public class Acitvity13 {
	
	public static void registerUser(String ageInput) {
		try {
			int age = Integer.parseInt(ageInput);
			if(age<18) {
				throw new IllegalArgumentException("Users must be at least 18 years old.");
			}else {
				System.out.println("Registration successful! Welcome aboard.");
			}
		}catch(NumberFormatException e) {
			System.out.println("Registration Failed -> Error: Age must be a valid number.");
		}catch (IllegalArgumentException e) {
			// Catches the exception we explicitly threw above
			System.out.println("Registration Failed -> Error: " + e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		String age;
		System.out.println("Enter your age:");
		Scanner sc = new Scanner(System.in);
		age = sc.next();
		
		sc.close();
		
		// Pass the age to registerUser
		registerUser(age);

	}

}
