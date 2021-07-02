package constants;

import com.google.common.collect.Multimap;
import com.google.common.collect.ArrayListMultimap;

public class CheckingCardFigurePresent {

    public boolean checkToSeeIfCardExists(String card, String figure, Multimap<String, String> map){
        boolean cardPresent = false;
        boolean figurePresent = false;


        for(String s: map.keySet()){
            if(map.containsKey(card)){
                cardPresent = true;
                break;
            }
        }

        for(String s: map.values()){
            if(map.containsValue(figure)){
                figurePresent = true;
                break;
            }
        }
        boolean result = cardPresent && figurePresent;
        return result;
    }
}

