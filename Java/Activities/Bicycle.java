package activities;

public class Bicycle implements BicycleOperations,BicycleParts{

	public int gears;
    public int currentSpeed;
    
    //Bicycle has one constructor
    public Bicycle(int gears,int currentSpeed) {
    	this.gears = gears;
    	this.currentSpeed = currentSpeed;
    }

	@Override
	public void applyBrake(int decrement) {
		currentSpeed-= decrement;
		
	}

	@Override
	public void speedUp(int increment) {
		currentSpeed+= currentSpeed;
		
	}
	
	//Method to print info of Bicycle
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
	}

}
