import java.io.File;
import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Configuration config;
    ArrayList<Ride> rides = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        new Main(args);
    }

    public Main (String[] args) {
        try {
            // Setup scanner
            Scanner scanner = new Scanner(new File(args[0]));

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

            // Naive solution
            count = 0;
            for (Ride ride : rides) {
                vehicles.get(count).addRide(ride.number);

                count++;
                count = count % vehicles.size();
            }

            Solution solution = new Solution();
            solution.setVehicles(vehicles);
            solution.write("output.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}