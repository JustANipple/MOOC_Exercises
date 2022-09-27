
import java.util.ArrayList;
import java.util.HashMap;


public class VehicleRegistry {
    private HashMap<LicensePlate, String> cars;
    
    public VehicleRegistry() {
        this.cars = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if(cars.containsKey(licensePlate)) {
            return false;
        } else {
            cars.put(licensePlate, owner);
            return true;
        }
    }
    
    public String get(LicensePlate licensePlate) {
        return cars.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if(cars.containsKey(licensePlate)) {
            cars.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates() {
        for(LicensePlate l : cars.keySet()) {
            System.out.println(l);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (String str : cars.values()) {
            if (!owners.contains(str)) {
                owners.add(str);
            }
        }
        for(String o : owners) {
            System.out.println(o);
        }            
    }
}
