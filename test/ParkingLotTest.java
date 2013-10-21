import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {
    private  List parkingLotList;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ParkingLot parkingLot3;
    @Before
    public void setUp() {

        parkingLotList = new ArrayList<ParkingLot>();
        parkingLot1 = new ParkingLot();
        parkingLot1.currentLocation = 0;
        parkingLot2 = new ParkingLot();
        parkingLot2.currentLocation = 0;
        parkingLot3 = new ParkingLot();
        parkingLot3.currentLocation = 0;

        parkingLot1.setName("parkingLot1");
        parkingLot2.setName("parkingLot2");
        parkingLot3.setName("parkingLot3");

        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
    }


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
        CarLocation carLocation = new CarLocation( 1);

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

    @Test
    public void should_equal_when_two_complexCarLocation_have_same_name_and_location(){
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setName("parkingLot");
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setName("parkingLot");
        CarLocation carLocation = new CarLocation(1);
        ComplexCarLocation complexCarLocation = new ComplexCarLocation(parkingLot1, carLocation);
        ComplexCarLocation complexCarLocation1 = new ComplexCarLocation(parkingLot2, carLocation);

        assertTrue(complexCarLocation1.equals(complexCarLocation));
    }

    @Test
    public void should_return_location_when_give_car_to_parking_boy() throws Exception {

        CarLocation carLocation = new CarLocation(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        ComplexCarLocation complexCarLocation = new ComplexCarLocation(parkingLot1, carLocation);

        assertTrue(parkingBoy.park(new Car("AC999"), (ArrayList<ParkingLot>) parkingLotList).equals(complexCarLocation));
    }

    @Test
    public void should_return_car_when_pick_up_car_by_parking_boy() throws Exception {
        parkingLot1.currentLocation = 0;
        ParkingBoy parkingBoy = new ParkingBoy();
        ComplexCarLocation complexCarLocation = parkingBoy.park(new Car("AC999"), (ArrayList<ParkingLot>) parkingLotList);
        assertTrue(parkingBoy.pickUp(complexCarLocation).equals(new Car("AC999")));
    }

    @Test
    public void should_return_complexCarLocation_when_there_are_more_than_one_parkingLot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        ComplexCarLocation complexCarLocation = new ComplexCarLocation(parkingLot1, new CarLocation(1));

        assertTrue(parkingBoy.park(new Car("AC999"), (ArrayList<ParkingLot>) parkingLotList).equals(complexCarLocation));
    }

    @Test
    public void should_return_complexCarLocation_when_first_parkingLot_is_full() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        parkingLot1.currentLocation = 10;

        ComplexCarLocation complexCarLocation = new ComplexCarLocation(parkingLot2, new CarLocation(1));

        assertTrue(parkingBoy.park(new Car("AC999"), (ArrayList<ParkingLot>) parkingLotList).equals(complexCarLocation));
    }

}
