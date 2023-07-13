package PB06_Ferrari;

public class Ferrari implements Car {
    private static final String MODEL = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }


    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        String pattern = "%s/%s/%s/%s";
        return String.format(pattern,
                this.MODEL,
                this.brakes(),
                this.gas(),
                this.driverName);
    }
}
