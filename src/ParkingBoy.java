import java.util.ArrayList;
import java.util.HashMap;

public class ParkingBoy {
    HashMap<ComplexCarLocation, Car> record = new HashMap<ComplexCarLocation, Car>();

    public ComplexCarLocation park(Car car, ArrayList<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.currentLocation < 10) {
                ParkingLot currentParkingLot = parkingLot;
                CarLocation carLocation = parkingLot.park(car);

                ComplexCarLocation complexCarLocation = recordWhenParking(car, currentParkingLot, carLocation);
                return complexCarLocation;
            } else
                continue;
        }
        ComplexCarLocation complexCarLocation = new ComplexCarLocation(new ParkingLot(), new CarLocation(0));
        return complexCarLocation;
    }

    private ComplexCarLocation recordWhenParking(Car car, ParkingLot currentParkingLot, CarLocation carLocation) {
        ComplexCarLocation complexCarLocation = new ComplexCarLocation(currentParkingLot, carLocation);
        record.put(complexCarLocation, car);
        return complexCarLocation;
    }

    public Car pickUp(ComplexCarLocation complexCarLocation) {
        return record.get(complexCarLocation);
    }
}
