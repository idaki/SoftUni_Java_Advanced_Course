import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<String> players = new ArrayList<>(Arrays.asList());



        String patter = "%s (%s):"
                + System.lineSeparator()
                + "Player: %s"
                + System.lineSeparator()
                + "Supplement: %d"
                + System.lineSeparator()
                + "Energy: %d";


       String print =  String.format(patter, "fieldName", "fieldType"
                , players.isEmpty()?"none": String.join(", ", players)
                , 3
                , 4
        );
        System.out.println(print);
    }
}