package PB06_Generic_Count_Method_Double;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    private List<T> list;



    public Box() {
        this.list = new ArrayList<>();
    }



    public List<T> getList() {
        return list;
    }



    public long countGreaterItems( T element) {


       return (int) list.stream().filter(i -> i.compareTo(element) > 0.0).count();
    }

}
