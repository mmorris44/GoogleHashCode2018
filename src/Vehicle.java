import java.util.ArrayList;

public class Vehicle {

    int numRides;
    ArrayList<Ride> rides;

    public Vehicle () {
        rides = new ArrayList<Ride>();
        numRides = 0;
    }

    public void addRide (Ride ride) {
        numRides += 1;
        rides.add(ride);
    }

    public int costIfAdd (Ride ride) {
        int total = getTotalTimeSteps();
        if (rides.size() == 0) {
            total += getDistance(0, ride.startColumn, 0, ride.startRow);
        } else {
            total += getDistance(rides.get(rides.size() - 1), ride);
        }
        total += ride.getDistance();
        return total;
    }

    public int getTotalTimeSteps () {
        int total = 0;
        for (int i = 0; i < rides.size(); i++) {
            Ride ride = rides.get(i);

            // If first ride
            if (i == 0) {
                total += getDistance(0, ride.startColumn, 0, ride.startRow);
            }

            total += ride.getDistance();

            // If not at end
            if (i + 1 < rides.size()) {
                total += getDistance(rides.get(i), rides.get(i + 1));
            }
        }
        return total;
    }

    public int getDistance (int startColumn, int endColumn, int startRow, int endRow) {
        return Math.abs(startColumn - endColumn) + Math.abs(startRow - endRow);
    }

    // Distance from r1 end to r2 start
    public int getDistance (Ride r1, Ride r2) {
        return getDistance(r1.endColumn, r2.startColumn, r1.endRow, r2.startRow);
    }

    public String toString () {
        String ret = numRides + "";
        for (Ride ride : rides) {
            ret += " " + ride.number;
        }
        return ret;
    }

}
