package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

public class CarShopTests {
    private static final int TEST_HP = 10;

    private Car car1;
    private Car car2;
    private CarShop carShop;

    @Before
    public void SetUpInitialObjects() {
        this.car1 = new Car("car1", 10, 55.5);
        this.car2 = new Car("car2", 20, 110.1);
        this.carShop = new CarShop();
        carShop.add(car1);
        carShop.add(car2);
    }

    @Test
    public void testFindAllCarsWithMaxHorseReturnCorrectCarObject() {

        List<Car> expected = new ArrayList<>();
        expected.add(car2);
        List<Car> actual = carShop.findAllCarsWithMaxHorsePower(TEST_HP);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNullObject(){
        Car car = null;
        carShop.add(car);
    }

    @Test
    public void testAddPositiveCase(){
        Car expected = car1;
        Car actual = carShop.getCars().get(0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetCarsPositiveCase(){
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        expected.add(car2);
        List<Car> actual = carShop.getCars();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetCountPositiveCase(){
        List<Car> expectedList = new ArrayList<>();
        expectedList.add(car1);
        expectedList.add(car2);
        int expected = expectedList.size();
        int  actual = carShop.getCount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetTheMostLuxuryCarPositiveCase(){
    Car expected = car2;
    Car actual = carShop.getTheMostLuxuryCar();

    Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindAllCarByModelPositiveCase(){
       Car car3= new Car("car2", 20, 110.1);
       carShop.add(car3);
        List<Car> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car3);
        List<Car> actual = carShop.findAllCarByModel("car2");

        Assert.assertEquals(expected,actual);
    }

    @Test

    public void testRemoveVehiclePositiveCase(){


        Assert.assertTrue(carShop.remove(car1));
    }

}

