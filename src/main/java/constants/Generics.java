package constants;

import java.util.List;

public class Generics {

    public  <T> void printList(List<T> mylist) {
        for (T t : mylist) {
            System.out.print(t + " ");
        }

    }

}
