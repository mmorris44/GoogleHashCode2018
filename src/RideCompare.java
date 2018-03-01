import java.util.Comparator;

public class RideCompare implements Comparator<Ride>{
	
	@Override
	public int compare(Ride r1, Ride r2) {
		double random = Math.random();
		if (random > 0.5) {
			return 1;
		} else {
			return -1;
		}
	}
}
