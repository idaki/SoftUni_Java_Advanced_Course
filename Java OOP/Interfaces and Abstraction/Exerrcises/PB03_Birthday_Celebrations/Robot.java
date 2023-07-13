package PB03_Birthday_Celebrations;

public class Robot implements Identifiable {
    private String id;
    private String Model;

    public Robot(String id, String model) {
        this.id = id;
        Model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return Model;
    }
}
