public class CarLocation {
    private final int number;

    public CarLocation( int number) {
        this.number = number;
    }

    public boolean equals(CarLocation carLocation){
        return carLocation.number == this.number;
    }
}
