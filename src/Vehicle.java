import java.util.ArrayList;

public class Vehicle {

    int numRides;
    ArrayList<Integer> rides;

    public Vehicle () {
        rides = new ArrayList<Integer>();
        numRides = 0;
    }

    public void addRide (int rideNumber) {
        numRides += 1;
        rides.add(rideNumber);
    }

    public String toString () {
        String ret = numRides + "";
        for (int ride : rides) {
            ret += " " + ride;
        }
        return ret;
    }

}
