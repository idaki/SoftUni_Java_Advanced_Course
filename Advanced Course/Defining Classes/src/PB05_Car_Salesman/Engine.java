package PB05_Car_Salesman;

public class Engine {
    private String model;
    private int power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;


    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }
    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }


}
