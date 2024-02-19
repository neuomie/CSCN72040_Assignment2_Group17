package assignment2.com;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrentLocation implements CurrentLocationIterator {
	
ArrayList<Coordinates> coordinates;
	
	public CurrentLocation()
	{
		coordinates = new ArrayList<Coordinates>();
		addLocation(0,0);
		addLocation(2,2);
		addLocation(2,4);
		addLocation(4,6);
		addLocation(6,8);
		addLocation(8,10);
		addLocation(6,6);
	}
	
	public void addLocation(int a, int b)
	{
		Coordinates XandY = new Coordinates(a, b);
		coordinates.add(XandY);
	}
	
	@Override
	public Iterator myIterator() {
		// TODO Auto-generated method stub
		return coordinates.iterator();
	}

}
