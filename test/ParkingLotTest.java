import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void should_return_location_when_parking() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        CarLocation carLocation = new CarLocation(1);

        assertTrue(parkingLot.park(new Car("AC888")).equals(carLocation));
    }

    @Test
    public void should_return_location_when_give_current_location() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.currentLocation = 0;
        CarLocation carLocation = new CarLocation(1);

        assertTrue(parkingLot.park(new Car("AC888")).equals(carLocation));
    }

    @Test
    public void should_return_null_when_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.currentLocation = 10;

        assertThat(parkingLot.park(new Car("AC888")), is((CarLocation)null));

    }

    @Test
    public void should_return_car_number_when_pickUp() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.currentLocation = 0;
        CarLocation carLocation = parkingLot.park(new Car("AC888"));

        assertTrue(parkingLot.pickUp(carLocation).equals(new Car("AC888")));
    }

}