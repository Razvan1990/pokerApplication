package transformerPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetToList {

    public List<Integer> transformSetToList(Set<Integer> cardSet){
      List<Integer> listOfSets = new ArrayList<>(cardSet);
        return listOfSets;
        }
    }

