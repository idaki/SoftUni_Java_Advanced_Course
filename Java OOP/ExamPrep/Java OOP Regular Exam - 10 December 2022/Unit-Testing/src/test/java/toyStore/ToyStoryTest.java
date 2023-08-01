package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {


    private Map<String, Toy> expectedToyShelf;
    private ToyStore toyStore;
    private Toy toy1;
    private Toy toy2;

    @Before
    public void setUp() {
        this.expectedToyShelf = new LinkedHashMap<>();
        this.expectedToyShelf.put("A", null);
        this.expectedToyShelf.put("B", null);
        this.expectedToyShelf.put("C", null);
        this.expectedToyShelf.put("D", null);
        this.expectedToyShelf.put("E", null);
        this.expectedToyShelf.put("F", null);
        this.expectedToyShelf.put("G", null);

        this.toyStore = new ToyStore();
    }


    //TODO: Write your tests here


    @Test
    public void testGetToyShelf() {
        Assert.assertEquals(expectedToyShelf, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToyWhenShelDoesNotExist() throws OperationNotSupportedException {
        toyStore.addToy("Test", new Toy("BMW", "car"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToyWhenShelfIsTaken() throws OperationNotSupportedException {
        toyStore.addToy("A", new Toy("BMW", "car"));
        toyStore.addToy("A", new Toy("Ford", "truck"));


    }

    @Test
    public void testIfItemExistsPositiveCaseTrue() throws OperationNotSupportedException {
        Toy expected = new Toy("BMW", "car");
        toyStore.addToy("A", expected);
        Toy actual = toyStore.getToyShelf().get("A");
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void testIfItemExistsPositiveCaseFalse() throws OperationNotSupportedException {
      Toy actual =  new Toy("Ford", "truck");
        Toy expected = new Toy("BMW", "car");
        toyStore.addToy("A", actual);
        actual = toyStore.getToyShelf().get("A");
        Assert.assertFalse(actual.equals(expected));
    }
//todo check logic
    @Test(expected = OperationNotSupportedException.class)
    public void testWhenItemExists() throws OperationNotSupportedException {

        Toy toy = new Toy("BMW", "car");
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);

    }

    @Test (expected = IllegalArgumentException.class)
    public void removeToyShelDoesNotExist(){
        Toy toy = new Toy("BMW", "car");
        toyStore.removeToy("Z",toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeToyDoesNotExist() throws OperationNotSupportedException {
        Toy toy = new Toy("BMW", "car");
        Toy toy2 = new Toy("Ford","truck");
       toyStore.addToy("A",toy2);
        toyStore.removeToy("A",toy);
    }
    @Test

    public void putNewShelf(){
        toyStore.
        System.out.println();
        Assert.assertTrue(toyStore.getToyShelf().containsKey("Z"));
    }




    //

    //
    //    public String removeToy(String shelf, Toy toy) {
    //        if (!this.toyShelf.containsKey(shelf)) {
    //            throw new IllegalArgumentException("Shelf doesn't exists!");
    //        }
    //
    //        if (this.toyShelf.get(shelf) != toy) {
    //            throw new IllegalArgumentException("Toy in that shelf doesn't exists!");
    //        }
    //
    //        this.toyShelf.put(shelf, null);
    //
    //        return String.format("Remove toy:%s successfully!", toy.getToyId());
    //    }


}