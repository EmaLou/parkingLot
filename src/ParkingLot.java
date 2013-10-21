import java.util.HashMap;

public class ParkingLot {
    private final int MaxParkingNumber = 10;


    private String name;
    public int currentLocation;
    HashMap<CarLocation, Car> record = new HashMap<CarLocation, Car>();


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public CarLocation park(Car car) {
        int parkingLocation = currentLocation + 1;
        if (parkingLocation > MaxParkingNumber) {
            return null;
        }
        CarLocation carLocation = new CarLocation(parkingLocation);
        record.put(carLocation, car);
        return carLocation;

    }

    public Car pickUp(CarLocation carLocation) {
        return record.get(carLocation);
    }
}
