package stuntClimb;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClimbingTests {

    private RockClimber climber1;
    private RockClimber climber2;
    private Climbing climbing1;
    private Climbing climbing2;

    @Before
    public void setUp() {
        this.climber1 = new RockClimber("climber1", 10);
        this.climber2 = new RockClimber("climber2", 20);
        this.climbing1 = new Climbing("climb1", 1);
        this.climbing2 = new Climbing("climb2", 2);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("climb1", climbing1.getName());
        Assert.assertEquals(1, climbing1.getCapacity());
        Assert.assertEquals(0, climbing1.getCount());
    }

    @Test
    public void addRockClimberPositive() {
        climbing1.addRockClimber(climber1);
        Assert.assertEquals(1, climbing1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRockClimberNegativeNoCapacity() {
        climbing1.addRockClimber(climber1);
        climbing1.addRockClimber(climber2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRockClimberNegativeExistingClimber() {
        climbing2.addRockClimber(climber1);
        climbing2.addRockClimber(climber1);
    }

    @Test
    public void removeRockClimber() {
        climbing2.addRockClimber(climber1);
        climbing2.addRockClimber(climber2);
        climbing2.removeRockClimber(climber1.getName());
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityNegative() {
        Climbing negativeCapacity = new Climbing("negative_capacity", -1);
    }

    @Test (expected = NullPointerException.class)
    public void setNameNegativeEmptyString(){
        Climbing negativeCapacity = new Climbing("", 2);
    }
    @Test (expected = NullPointerException.class)
    public void setNameNegativeNullString(){
        Climbing negativeCapacityEmptyString = new Climbing(null, 2);
    }


}
