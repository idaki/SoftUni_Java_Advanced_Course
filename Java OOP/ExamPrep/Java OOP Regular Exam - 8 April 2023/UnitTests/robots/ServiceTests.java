package robots;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class ServiceTests {



    @Test
    public void testGetNameReturnsCorrectData(){
        Service service = new Service("John",10);
        String name ="John";
        Assert.assertEquals("John", service.getName());
    }

    @Test
    public void testSetNamePositiveCase(){
        Service service = new Service("John",10);
        String name ="John";
        Assert.assertEquals("John", service.getName());
    }

    @Test (expected = NullPointerException.class )
    public void testSetNameNegativeCaseWhenTheValueIsNull(){
        String name = null;
        Service service = new Service(name,10);    }

    @Test (expected = NullPointerException.class )
    public void testSetNameNegativeCaseWhenTheValueIsEmptySpace(){
        String name = " ";
        Service service = new Service(name,10);    }

    @Test (expected = NullPointerException.class )
    public void testSetNameNegativeCaseWhenTheValueIsMultipleEmptySpaces(){
        String name = "      ";
        Service service = new Service(name,10);    }


    @Test
    public void testGetCapacityPositiveCase(){
        Service service = new Service("John",10);
        int capacity = 10;
        Assert.assertEquals(capacity, service.getCapacity());
    }

    @Test
    public void testSetCapacityPositiveCase(){
        Service service = new Service("John",10);
        int capacity = 10;
        Assert.assertEquals(capacity, service.getCapacity());
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testSetCapacityNegativeCaseWithNegativeNumber(){
        int capacity = -1;
        Service service = new Service("John",capacity);
    }

    @Test
    public void testSetCapacityEdgeCaseWithZero(){
        Service service = new Service("John",0);
        int capacity = 0;
        Assert.assertEquals(capacity, service.getCapacity());
    }


    @Test
    public void testGetCountPositiveCaseOneElement(){
        Service service = new Service("John",10);
        int capacity = 10;
        Robot robot = new Robot("Slim");
        service.add(robot);
        Assert.assertEquals(1,service.getCount());
    }

    @Test
    public void testGetCountPositiveCaseMultipleElement(){
        Service service = new Service("John",10);
        int capacity = 10;
        Robot robot1 = new Robot("Slim");
        Robot robot2 = new Robot("Spens");
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals(2,service.getCount());
    }

    @Test
    public void testAddRobotPositiveCase(){
        Service service = new Service("John",10);
        int capacity = 10;
        Robot robot1 = new Robot("Slim");
        Robot robot2 = new Robot("Spens");
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals(2,service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddRobotNegativeCaseOutOFBound(){
        Service service = new Service("John",1);
        int capacity = 10;
        Robot robot1 = new Robot("Slim");
        Robot robot2 = new Robot("Spens");
        service.add(robot1);
        service.add(robot2);
    }

    @Test
    public void testRemoveFromListByRobotNamePositiveCase(){
        Service service = new Service("John",1);
        int capacity = 10;
        String name ="Slim";
        Robot robot1 = new Robot("Slim");
        service.add(robot1);
        service.remove(name);
        Assert.assertEquals(0,service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFromListByRobotNameNegativeCaseWhenRobotIsNull(){
        Service service = new Service("John",1);
        int capacity = 10;
        String name ="Slim";
        Robot robot1 = new Robot("Slim");
        service.add(robot1);
        service.remove("Spens");
    }


    @Test ()
    public void testForSaleRobotNamePositiveCase(){
        Service service = new Service("John",1);
        int capacity = 10;
        String name ="Slim";
        Robot robot1 = new Robot("Slim");
        service.add(robot1);
        Robot robot2 = service.forSale("Slim");
        Assert.assertTrue(!robot2.isReadyForSale());

    }




    @Test (expected = IllegalArgumentException.class)
    public void testForSaleRobotNameNegativeCaseWhenRobotIsNull(){
        Service service = new Service("John",1);
        int capacity = 10;
        String name ="Slim";
        Robot robot1 = new Robot("Slim");
        service.add(robot1);
        service.forSale("TestName");
    }




//    public Robot forSale(String name){
//        Robot robot = this.robot.stream()
//                .filter(f -> name.equals(f.getName()))
//                .findAny()
//                .orElse(null);
//        if (robot == null){
//            throw new IllegalArgumentException(String.format("Robot with name %s doesn't exist!", name));
//        }
//        robot.setReadyForSale(false);
//
//        return robot;
//    }
//
//    public String report(){
//        String names = this.robot.stream().map(Robot::getName).collect(Collectors.joining(", "));
//        return String.format("The robot %s is in the service %s!", names, this.name);
//    }



}
