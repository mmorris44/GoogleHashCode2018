import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Solution {

    ArrayList<Vehicle> vehicles;

    public Solution () {
        vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle (Vehicle v) {
        vehicles.add(v);
    }

    public void setVehicles (ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String toString() {
        String ret = "";
        for (Vehicle vehicle : vehicles) {
            ret += vehicle.toString();
            ret += "\n";
        }
        ret = ret.substring(0, ret.length() - 1); // Remove trailing newline
        return ret;
    }

    public void write (String filename) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(filename));
            pr.write(this.toString());
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
