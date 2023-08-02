package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    private static final int CAPACITY = 10;
    private static final String NAME = "FarmName";
    private static final String ANIMAL_TYPE = "Tiger";
    private static final String FALSE_ANIMAL_TYPE = "False";
    private static final double ANIMAL_ENERGY = 10.5;


    @Test
    public void testConstructorPositiveCaseSetName() {

        Farm farmville = new Farm(NAME, CAPACITY);
        Assert.assertTrue(farmville.getName().equals(NAME));
    }

    @Test
    public void testConstructorPositiveCaseSetCapacity() {
        Farm farmville = new Farm(NAME, CAPACITY);
        Assert.assertEquals(CAPACITY, farmville.getCapacity());
    }

    @Test
    public void testGetName() {

        Farm farmville = new Farm(NAME, CAPACITY);
        Assert.assertEquals(NAME, farmville.getName());
    }

    @Test
    public void testGetGetCount() {
        Animal animal = new Animal(ANIMAL_TYPE, ANIMAL_ENERGY);
        Farm farmville = new Farm(NAME, CAPACITY);
        farmville.add(animal);

        Assert.assertEquals(1, farmville.getCount());
    }

    @Test
    public void testGetCapacity() {
        Farm farmville = new Farm(NAME, CAPACITY);
        Assert.assertEquals(CAPACITY, farmville.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalWhenFarmIsFull() {
        Farm farmville = new Farm(NAME, CAPACITY-9);
        farmville.add(new Animal(ANIMAL_TYPE,ANIMAL_ENERGY));
        farmville.add(new Animal("A",10.5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalWhenAnimalExist() {
        Farm farmville = new Farm(NAME, CAPACITY);
        farmville.add(new Animal(ANIMAL_TYPE,ANIMAL_ENERGY));
        farmville.add(new Animal(ANIMAL_TYPE,ANIMAL_ENERGY));
    }

    @Test
    public void testAddAnimalWhenAnimalPositiveCase() {
        Farm farmville = new Farm(NAME, CAPACITY);
        farmville.add(new Animal(ANIMAL_TYPE,ANIMAL_ENERGY));
      Assert.assertEquals(1, farmville.getCount());
    }

    @Test
    public void removeAnimalPositiveTrueCase(){
        Farm farmville = new Farm(NAME, CAPACITY);
        Animal animal = new Animal(ANIMAL_TYPE,ANIMAL_ENERGY);
        farmville.add(animal);
        Assert.assertTrue(farmville.remove(ANIMAL_TYPE));
    }

    @Test
    public void removeAnimalPositiveFalseCase(){
        Farm farmville = new Farm(NAME, CAPACITY);
        Animal animal = new Animal(ANIMAL_TYPE,ANIMAL_ENERGY);
        farmville.add(animal);
        Assert.assertFalse(farmville.remove(FALSE_ANIMAL_TYPE));
    }

    @Test (expected = IllegalArgumentException.class)

    public void testSetCapacityWhenBelowZero(){
        Farm farmville = new Farm(NAME, -5);

    }
@Test (expected = NullPointerException.class)
    public void testSetNameWhenNull(){
        Farm farmville = new Farm(null, CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameWhenEmptySpace(){
        Farm farmville = new Farm("   ", CAPACITY);
    }
    //
    //    private void setName(String name) {
    //        if (name == null || name.trim().isEmpty()) {
    //            throw new NullPointerException(INVALID_FARM_NAME);
    //        }
    //
    //        this.name = name;




  //public boolean remove(String animalType) {
    //        Animal animal = this.animals
    //                .stream()
    //                .filter(a -> a.getType().equals(animalType))
    //                .findFirst()
    //                .orElse(null);
    //

}
