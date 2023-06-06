package PB02_Generic_Box_of_Integer;

public class Box <T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(this.value.getClass().getTypeName()+": "+this.value);
    }
}
