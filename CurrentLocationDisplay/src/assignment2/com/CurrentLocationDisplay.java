package assignment2.com;
import java.util.Iterator;

public class CurrentLocationDisplay  {
	
	CurrentLocationIterator myCLD;
	
	public CurrentLocationDisplay(CurrentLocationIterator cl)
	{
		myCLD = cl;
	}
	
	public void showCurrentLocation()
	{
		Iterator myCurrLoc = myCLD.myIterator();
		Print(myCurrLoc);
	}
	
	public void Print(Iterator it)
	{
		while(it.hasNext())
		{
			Coordinates co = (Coordinates) it.next();
			System.out.println("(" + co.getX() + ", " + co.getY() + ")");
		}
	}

}
