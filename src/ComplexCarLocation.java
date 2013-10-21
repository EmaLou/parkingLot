public class ComplexCarLocation {
    private final ParkingLot parkingLot;
    private final CarLocation carLocation;

    public ComplexCarLocation(ParkingLot parkingLot, CarLocation carLocation) {
        this.parkingLot = parkingLot;
        this.carLocation = carLocation;
    }

    public boolean equals(ComplexCarLocation complexCarLocation){
        return this.parkingLot.getName().equals(complexCarLocation.parkingLot.getName()) && this.carLocation.equals(complexCarLocation.carLocation);
    }
}
