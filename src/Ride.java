public class Ride {

    // Parameters for start and end locations
    int startRow;
    int startColumn;
    int endRow;
    int endColumn;

    // Number to ID the ride
    int number;

    // Earliest start and latest finish
    int earliestStart;
    int latestFinish;

    public Ride (String line, int number) {
        this.number = number;

        String[] parts = line.split(" ");
        startRow = Integer.parseInt(parts[0]);
        startColumn = Integer.parseInt(parts[1]);
        endRow = Integer.parseInt(parts[2]);
        endColumn = Integer.parseInt(parts[3]);
        earliestStart = Integer.parseInt(parts[4]);
        latestFinish = Integer.parseInt(parts[5]);
    }

}
