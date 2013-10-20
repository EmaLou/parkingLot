public class Car {
    private final String number  ;

    public Car(String number) {
        this.number = number;
    }


    public boolean equals(Car car){
        return car.number == this.number;
    }
}
