package PB03_Generic_Swap_Method_String;

import java.util.ArrayList;
import java.util.List;

public class GenericSwapMethod<T> {
    private List<T> list;
    private int firstIndex;
    private int secondIndex;

    public GenericSwapMethod() {
        this.list = new ArrayList<>();
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public List<T> getList() {
        return list;
    }

    public  List<T> swapMethod(){
        if (!isOutOfBound()&&this.list.size()!=1){
        T firstElement= getList().get(this.firstIndex);
        T secondElement= getList().get(this.secondIndex);
        list.set(firstIndex,secondElement);
        list.set(secondIndex,firstElement);
        } else if (this.list.size()==1) {

        }
        return this.list;
    }
    private boolean isOutOfBound() {
        if (this.firstIndex<0|| this.firstIndex>=this.list.size()
                || this.secondIndex<0|| this.secondIndex>=this.list.size()){
             throw new RuntimeException("Out of bound index");
        }
        return false;
    }


}
