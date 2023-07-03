package PB04_Stack_of_Strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StackOfStrings{

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        data.add(item);
    }
    public String pop(){
        return data.remove(0);
    }
    public String peek(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
