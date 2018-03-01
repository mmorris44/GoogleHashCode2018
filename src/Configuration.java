public class Configuration {
    // City dimensions
    int rows;
    int columns;

    // Number of vehicles available and rides requested
    int vehicles;
    int rides;

    // Bonus per ride for starting ride on time
    int bonus;

    // Number of steps in simulation
    int steps;

    public Configuration (String line) {
        String[] parts = line.split(" ");
        rows = Integer.parseInt(parts[0]);
        columns = Integer.parseInt(parts[1]);
        vehicles = Integer.parseInt(parts[2]);
        rides = Integer.parseInt(parts[3]);
        bonus = Integer.parseInt(parts[4]);
        steps = Integer.parseInt(parts[5]);
    }
}