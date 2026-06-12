package activities;

public class Activity3 {

	public static void main(String[] args) {
		// Create the call object
				Activity3 obj = new Activity3();

				// Call the adjustDevice
				System.out.println(obj.adjustDevice("THERMOSTAT", 41));
				System.out.println(obj.adjustDevice("THERMOSTAT", 25));
				System.out.println(obj.adjustDevice("LIGHT", 50));

	}
	
	public String adjustDevice(String device, int value) {
		String status;
		
		status = switch(device){
		case null -> "Invalid device type.";
		case String d when d.equals("THERMOSTAT") && value >= 40 -> "[Thermostat] Warning: Temperature high";
		case String d when d.equals("THERMOSTAT") && value < 40 -> "[Thermostat] Temperature is set to " + value;
		case "LIGHT" -> "[Light] Adjusting brightness to " + value + "%.";
		default -> "Unknown device given";
		};
		// Return the status message
		return status;
		}
	
		
	}


