package activities;

public class Activity1 {

	public static void main(String[] args) {
		//Create an Object of the Car class
		Car carName = new Car();
		
		//Initialize the values
		carName.make = 2014;
		carName.color = "Black";
		carName.transmission = "Manual";
		
		//Call the methods to print characteristics
		carName.displayCharacteristics();
		System.out.println("---------------");
		carName.accelarate();
		carName.brake();

	}

}
