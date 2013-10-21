import java.util.HashMap;

public class ParkingBoy {
    HashMap<ComplexCarLocation, Car> record = new HashMap<ComplexCarLocation, Car>();

    public ComplexCarLocation park(Car car) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("parkingLot1");
        parkingLot.currentLocation = 0;
        CarLocation carLocation = parkingLot.park(car);

        ComplexCarLocation complexCarLocation = new ComplexCarLocation(parkingLot, carLocation);
        record.put(complexCarLocation, car);
        return complexCarLocation;
    }

    public Car pickUp(ComplexCarLocation complexCarLocation) {
        return record.get(complexCarLocation);

    }
}
