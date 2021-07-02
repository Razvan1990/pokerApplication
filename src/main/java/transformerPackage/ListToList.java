package transformerPackage;

import generationMethods.AceMethod;

import java.util.ArrayList;
import java.util.List;

public class ListToList {

    public List<Integer> cardsToIntList(List<String> cardSringList, String player){
        AceMethod aceMethod = new AceMethod();
        List<Integer> myIntList = new ArrayList<>();
        int cardValue = 0;
        for(int i =0;i<cardSringList.size();i++){
            String card = cardSringList.get(i);
            switch (card){
                case "2":
                    cardValue = 2;
                    myIntList.add(cardValue);
                    break;
                case "3":
                    cardValue = 3;
                    myIntList.add(cardValue);
                    break;
                case "4":
                    cardValue = 4;
                    myIntList.add(cardValue);
                    break;
                case "5":
                    cardValue = 5;
                    myIntList.add(cardValue);
                    break;
                case "6":
                    cardValue = 6;
                    myIntList.add(cardValue);
                    break;
                case "7":
                    cardValue = 7;
                    myIntList.add(cardValue);
                    break;
                case "8":
                    cardValue = 8;
                    myIntList.add(cardValue);
                    break;
                case "9":
                    cardValue = 9;
                    myIntList.add(cardValue);
                    break;
                case "10":
                    cardValue = 10;
                    myIntList.add(cardValue);
                    break;
                case "J":
                    cardValue = 11;
                    myIntList.add(cardValue);
                    break;
                case "Q":
                    cardValue = 12;
                    myIntList.add(cardValue);
                    break;
                case "K":
                    cardValue = 13;
                    myIntList.add(cardValue);
                    break;
                case "A":
                    cardValue = 1;
                    myIntList.add(cardValue);
                    cardValue = 15;
                    myIntList.add(cardValue);
                    break;
            }
        }
        return myIntList;
    }
    public List<Integer> figuresToIntList(List<String> figuresSringList, String player){
        List<Integer> figuresIntList = new ArrayList<>();
        int figureValue = 0;
        for (int i =0;i<figuresSringList.size();i++){
            String figure = figuresSringList.get(i);
            switch (figure){
                case "Inima":
                    figureValue = 100;
                    figuresIntList.add(figureValue);
                    break;
                case "Caro":
                    figureValue = 200;
                    figuresIntList.add(figureValue);
                    break;
                case "Frunza":
                    figureValue = 300;
                    figuresIntList.add(figureValue);
                    break;
                case "Trefla":
                    figureValue = 400;
                    figuresIntList.add(figureValue);
                    break;
            }
        }
        return figuresIntList;
    }
}
