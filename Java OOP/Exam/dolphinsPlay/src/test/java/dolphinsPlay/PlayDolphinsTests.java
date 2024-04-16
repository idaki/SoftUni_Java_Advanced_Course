package dolphinsPlay;

//TODO write unit tests

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;


public class PlayDolphinsTests {

    private Dolphin doplhin1;
    private Dolphin doplhin2;

    private DolphinsPlay play1;
    private DolphinsPlay play2;

    @Before
    public void setup() {
        this.doplhin1 = new Dolphin("small", "white", 100);
        this.doplhin2 = new Dolphin("big", "black", 200);
        this.play1 = new DolphinsPlay("Play1", 1);
        this.play2 = new DolphinsPlay("Play2", 2);
    }

    ;


    @Test
    public void testConstructor() {
        Assert.assertEquals("Play1", play1.getName());
        Assert.assertEquals(1, play1.getCapacity());
    }
//
//    @Test
//    public void getDolphins() {
//        this.play2.addDolphin(doplhin1);
//        this.play2.addDolphin(doplhin2);
//        Collection<Dolphin> test = play2.getDolphins();
//        Assert.assertEquals(2, play2.getCount());
//        Assert.assertThrows(UnsupportedOperationException.class, () -> {
//            test.add(new Dolphin("small", "white", 100));
//        });
//
//        Assert.assertThrows(UnsupportedOperationException.class, () -> {
//            test.remove(doplhin1);
//        });
//
//        Assert.assertThrows(UnsupportedOperationException.class, () -> {
//            test.clear();
//        });
//
//    }

    @Test
    public void returnGetCount() {
        this.play2.addDolphin(doplhin1);
        this.play2.addDolphin(doplhin2);
        Assert.assertEquals(2, this.play2.getDolphins().size());
    }


    @Test
    public void addDolphinPositive() {
        this.play1.addDolphin(doplhin1);
        Assert.assertEquals(1, play1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinNegativeNoCapacity() {
        this.play1.addDolphin(doplhin1);
        this.play1.addDolphin(doplhin2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinNegativeNullDolphin() {
        this.play1.addDolphin(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinNegativeCaseAlreadyExist() {
        this.play2.addDolphin(doplhin1);
        this.play2.addDolphin(doplhin1);
    }

    @Test
    public void removeDolphine() {
        this.play2.addDolphin(doplhin1);
        this.play2.addDolphin(doplhin2);
        Assert.assertTrue(this.play2.removeDolphin(doplhin1.getName()));
    }

    @Test
    public void getTheDolphinWithTheMaxEnergy(){
        this.play2.addDolphin(doplhin1);
        this.play2.addDolphin(doplhin2);
        Assert.assertEquals(doplhin2.getName(),this.play2.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void findAllDolphinsByType(){
        this.play2.addDolphin(doplhin1);
        this.play2.addDolphin(doplhin2);
        Collection<Dolphin> test = new ArrayList<>();
        test.add(doplhin2);
        Assert.assertEquals(test,this.play2.findAllDolphinsByType("big"));
    }

    @Test
    public void getCapacity(){
        Assert.assertEquals(1,this.play1.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)

    public void  setNegativeCapacity(){
        DolphinsPlay dolphinsPlay = new DolphinsPlay("negative", -1);
    }


}
