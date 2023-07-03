package PB03_Random_Array_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {
    public E getRandomElement(List<E> list){
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.remove(index);
    }
}
