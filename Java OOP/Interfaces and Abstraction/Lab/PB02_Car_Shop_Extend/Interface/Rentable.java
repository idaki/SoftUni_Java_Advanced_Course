package PB02_Car_Shop_Extend.Interface;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
