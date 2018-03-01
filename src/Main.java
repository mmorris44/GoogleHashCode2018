import java.io.File;
import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final String FILE_NAME = "e_high_bonus.in";

    Configuration config;
    ArrayList<Ride> rides = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        try {
            // Setup scanner
            Scanner scanner = new Scanner(new File(FILE_NAME));

            // Read in config
            String line = scanner.nextLine();
            config  = new Configuration(line);

            // Read in rides
            int count = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                rides.add(new Ride(line, count));
                count++;
            }

            // Setup vehicles
            for (int i = 0; i < config.vehicles; i++) {
                vehicles.add(new Vehicle());
            }
            	
            Collections.sort(rides, new RideCompare());
            
            // Naive solution
            count = 0;
            for (Ride ride : rides) {
                Vehicle vehicle = vehicles.get(count);

                int cost = vehicle.costIfAdd(ride);
                if (cost > ride.latestFinish) {
                    continue;
                }

                vehicle.addRide(ride);
                count++;
                count = count % vehicles.size();
            }

            Solution solution = new Solution();
            solution.setVehicles(vehicles);
            solution.write(FILE_NAME.split("\\.")[0] + ".out");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}