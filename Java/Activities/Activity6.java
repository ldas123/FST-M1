package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// There's a plane with max 10 passengers
		Plane plane = new Plane(10);
		// Add passengers to the list
		plane.onboard("Laxmi");
        plane.onboard("Kabir");
        plane.onboard("Das");
        // Plane takes off
        System.out.println("Plane took Of at "+plane.takeOff());
        // Print list of peoples onboard
        System.out.println("Peoples on the plane: "+plane.getPassengers());
        //Flying.....
        Thread.sleep(5000);
        //Plane has landed
        plane.land();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());

	}

}
