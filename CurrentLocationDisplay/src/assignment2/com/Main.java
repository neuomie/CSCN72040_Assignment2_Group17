package assignment2.com;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentLocation currentLocation = new CurrentLocation();
		
		CurrentLocationDisplay vehicleLocation = new CurrentLocationDisplay(currentLocation);
		
		vehicleLocation.showCurrentLocation();

	}

}
