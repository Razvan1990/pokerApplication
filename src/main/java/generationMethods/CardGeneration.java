package generationMethods;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import constants.CardsAndSymbols;

public class CardGeneration {

    public String generateRandomCard() {
        int value = (int) Math.floor(Math.random() * CardsAndSymbols.cards.length);
        return CardsAndSymbols.cards[value];
    }

    public String generateRandomFigure() {
        int value = (int) Math.floor(Math.random() * CardsAndSymbols.symbols.length);
        return CardsAndSymbols.symbols[value];
    }

    public Multimap<String, String> playersCard(String card, String figure) {
        Multimap<String, String> myMap = ArrayListMultimap.create();
        myMap.put(card, figure);
        return myMap;
    }

    public void showCard(Multimap<String, String> playersCard) {
        for (String s : playersCard.keySet()) {
            System.out.print(s + " " + playersCard.get(s));
        }
    }

    public void addCard(String card, String figure, Multimap<String, String> map) {
        map.put(card, figure);
    }


}

