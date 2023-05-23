package LAB.PB09;

public class main {
    public static void main(String[] args) {
        Cube cube = new Cube("blue", 1, 5, 6);
        String pathCubeInfo = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\src\\LAB\\PB09";

        //записваме обект във файл (serialization - сериализация)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathCubeInfo));
        oos.writeObject(cube);
        oos.close();
    }
}
