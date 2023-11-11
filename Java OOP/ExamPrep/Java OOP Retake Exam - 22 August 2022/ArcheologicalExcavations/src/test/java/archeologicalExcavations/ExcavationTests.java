package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Excavation excavation;
    private Archaeologist archaeologist1;
    private Archaeologist archaeologist2;


    @Before
    public void setUpTestObject() {
        excavation = new Excavation("Test", 10);
        archaeologist1 = new Archaeologist("Person1", 22.2);
        archaeologist2 = new Archaeologist("Person2", 22.2);
    }


    @Test
    public void testGetCountWorksCorrectlyWithMultipleElements() {
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test
    public void testGetCountWorksWithEmptyList() {
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void testGetNameCorrectlyWithOneWord() {
        Assert.assertEquals("Test", excavation.getName());
    }

    @Test
    public void testGetNameCorrectlyWithTwoWordsSeparatedBySpace() {
        Excavation excavation2 = new Excavation("Test Name", 10);
        Assert.assertEquals("Test Name", excavation2.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameFailsWithEmptyString() {
        Excavation excavation2 = new Excavation(" ", 10);
    }

    @Test
    public void testGetCapacityCorrectly() {
        Assert.assertEquals(10, excavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistFailsWhenCapacityIsReached() {
        Excavation excavationLimit = new Excavation("Test", 1);
        excavationLimit.addArchaeologist(archaeologist1);
        excavationLimit.addArchaeologist(archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistFailsWhenNameIsNotUnique() {

        excavation.addArchaeologist(new Archaeologist("John", 5));
        excavation.addArchaeologist(new Archaeologist("John", 5));
    }

    @Test
    public void testAddArchaeologistPositiveCase() {
        int listSizeBeforeOperation = excavation.getCount();
        excavation.addArchaeologist(archaeologist1);
        Assert.assertEquals(++listSizeBeforeOperation, excavation.getCount());
    }

    @Test

    public void testIfRemoveArchaeologistPositiveCaseIfExist() {

        excavation.addArchaeologist(archaeologist1);

        Assert.assertTrue(excavation.removeArchaeologist(archaeologist1.getName()));
    }

    @Test
    public void testIfRemoveArchaeologistPositiveCaseIfDoesNotExist() {

        excavation.addArchaeologist(archaeologist1);

        Assert.assertFalse(excavation.removeArchaeologist(archaeologist2.getName()));
    }


    @Test

    public void testSetCapacityWithValueAboveZero() {
        Excavation excavation = new Excavation("Test", 100);
        Assert.assertEquals(100, excavation.getCapacity());
    }




    @Test(expected = IllegalArgumentException.class)

    public void testSetCapacityWithNegativeValue() {
        Excavation excavation = new Excavation("Test", -10);
        Assert.assertEquals(-10, excavation.getCapacity());
    }
    //

    @Test (expected = NullPointerException.class)
    public void testSetNameWithEmptyValue() {
        Excavation excavation1 = new Excavation(" ", 2);

    }

    @Test (expected = NullPointerException.class)
    public void testSetNameWithNullValue() {
        Excavation excavation1 = new Excavation(null, 2);

    }


}
