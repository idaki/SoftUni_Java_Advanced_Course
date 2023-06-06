package PB05_Car_Salesman;

public class Car {
    //ХАРАКТЕРИСТИКИ
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    //КОНСТРУКТОР

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //""

        sb.append(this.model).append(":").append(System.lineSeparator()); //модел на колата
        sb.append(this.engine.getModel()).append(":").append(System.lineSeparator()); //модел на двигателя на колата
        sb.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());


        sb.append("Displacement: ");

        if (this.engine.getDisplacement() == 0 ) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }


        sb.append("Efficiency: ");
        //нямаме = null; имаме = текст
        if (this.engine.getEfficiency() == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }


        sb.append("Weight: ");

        if (this.weight == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }


        sb.append("Color: ");

        if (this.color == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }
}