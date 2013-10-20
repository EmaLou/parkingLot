import java.util.HashMap;

public class ParkingLot {
    private final int MaxParkingNumber = 10;
    public int currentLocation;
    HashMap<CarLocation, Car> record = new HashMap<CarLocation, Car>();

    public CarLocation park(Car car) {
        if (currentLocation + 1 > MaxParkingNumber) {
            return null;
        }
        CarLocation carLocation = new CarLocation(currentLocation + 1);
        record.put(carLocation, car);
        return carLocation;

    }

    public Car pickUp(CarLocation carLocation) {
        return record.get(carLocation);
    }
}
