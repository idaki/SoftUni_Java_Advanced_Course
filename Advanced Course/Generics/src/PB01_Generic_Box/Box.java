package PB01_Generic_Box;

public class Box <T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  String.format(this.value.getClass().getTypeName().toString()+": "+this.value);
    }
}
