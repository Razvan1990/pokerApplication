package transformerPackage;

import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapToList {

    public List<String> cardList(Multimap<String, String>cardMap){
        List<String> cardList = new ArrayList<>();
        for(String s:cardMap.keys()){
            cardList.add(s);
        }
        return cardList;
    }

    public List<String> figuresList(Multimap<String, String> figuresMap){
        List<String> figuresList = new ArrayList<>();
        for(String s : figuresMap.values()){
            figuresList.add(s);
        }
        return figuresList;
    }
    public List<String> addCardsInList(List<String> cardsList, String card){
        List<String> allListCard = new ArrayList<>();
        allListCard.addAll(cardsList);
        allListCard.add(card);
        return allListCard;
    }
    public List<String> addFiguresList (List<String>figuresList, String figure){
        List<String> allFiguresList = new ArrayList<>();
        allFiguresList.addAll(figuresList);
        allFiguresList.add(figure);
        return allFiguresList;
    }
    //de control sa vedem daca e ok

    public void showCardList(List<String> myList){
        for (String s: myList){
            System.out.print(s+" ");
        }
    }

}
