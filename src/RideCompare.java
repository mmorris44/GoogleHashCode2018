import java.util.Comparator;

public class RideCompare implements Comparator<Ride>{
	
	@Override
	public int compare(Ride r1, Ride r2) {
		if (r1.startRow + r1.startColumn <= r2.startRow + r2.startColumn) return 1;
		else return -1;
		
	}
}
