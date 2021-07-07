package games;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

public class SkeletonGamesToConditions {


        public List<Integer> sortMainList(List<Integer> originalLists) {

            List<Integer> newList = new ArrayList<>(originalLists.size());

            for (int i = 0; i < originalLists.size(); i++) {
                newList.add(originalLists.get(i));
            }
            for (int i = 0; i < newList.size(); i++) {
                for (int j = 0; j < newList.size(); j++) {
                    if (newList.get(i) < newList.get(j)) {
                        int temp = newList.get(i);
                        newList.set(i, newList.get(j));
                        newList.set(j, temp);

                    }
                }
            }
            return newList;
        }

        public List<Integer> addCardsOfGameInList(List<Integer> cardListArrange) {
            //parcurgem lista cu carti
            int counter = 1;
            int a = cardListArrange.get(0);
            List<Integer> cardGameList = new ArrayList<>();
            cardGameList.add(cardListArrange.get(0));
            //ne va adauga in lista elementele din chinta ce lipsesc
            for (int i = 1; i < cardListArrange.size(); i++) {
                if (cardListArrange.get(i) - a == counter) {
                    cardGameList.add(cardListArrange.get(i));
                    counter++;

                } else if (counter == 2) {
                    a = cardListArrange.get(i);
                    cardGameList.clear();
                    counter = 1;
                } else {
                    a = cardListArrange.get(i);
                    //cardGameList.remove(i-1);
                    counter = 1;
                }
            }
            if (cardGameList.size() >= 5) {
                for (int i = 0; i < cardGameList.size() - 1; i++) {
                    if (cardGameList.get(1) - cardGameList.get(0) != 1) {
                        cardGameList.remove(0);
                    }
                }
            }
            if(cardGameList.size()>=5) {
                if (cardGameList.get(cardGameList.size() - 1) - cardGameList.get(cardGameList.size() - 2) != 1) {
                    cardGameList.remove(cardGameList.size() - 1);
                }
            }


            //adaugam elementul prim din chinta ce lipseste
            if(cardGameList.size()>=4) {
                for (int i = 0; i < cardListArrange.size(); i++) {
                    if (cardGameList.get(0) == cardListArrange.get(i)) {
                        cardGameList.add(0, cardGameList.get(0) - 1);
                    }
                }
            }
            boolean isValid = false;
            for (int i = 0; i < cardGameList.size() - 1; i++) {

                if (cardGameList.get(i) + 1 == cardGameList.get(i + 1) && cardGameList.size() >= 5) {
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return cardGameList;
            }

            cardGameList.clear();
            for (int i = 0; i < cardListArrange.size() - 1; i++) {
                if (cardListArrange.get(i) == cardListArrange.get(i + 1)) {
                    cardGameList.add(cardListArrange.get(i));
                }

            }
            //[2 3 3 3 3 10 10]-->[3 3 3 10]-> tot careu si dam remove la elementul lipsa
            if (cardGameList.size() == 4 && (((cardGameList.get(0) == cardGameList.get(1)) && (cardGameList.get(0) == cardGameList.get(2))) ||
                    ((cardGameList.get(1) == cardGameList.get(2)) && (cardGameList.get(1) == cardGameList.get(3))))) {
                if (cardGameList.get(0) != cardGameList.get(1)) {
                    cardGameList.remove(0);
                    return cardGameList;
                } else if (cardGameList.get(1) != cardGameList.get(3)) {
                    cardGameList.remove(cardGameList.get(3));
                    return cardGameList;

                }
            } else if (cardGameList.size() == 3) {
                //[2 4 8 8 8 8 10 15] -> [8 8 8](careu clasic)
                if ((cardGameList.get(0) == cardGameList.get(1)) && (cardGameList.get(0) == cardGameList.get(2))) {
                    return cardGameList;
                }
                //[5 6 7 7 9 9 9]-> [7 9 9]
                else if (((cardGameList.get(0) != cardGameList.get(1)) && (cardGameList.get(1) == cardGameList.get(2))) ||
                        ((cardGameList.get(1) != cardGameList.get(2)) &&
                                (cardGameList.get(0) == cardGameList.get(1)))) {
                    return cardGameList;
                } else {
                    cardGameList.remove(0);
                    return cardGameList;
                }
            } else if (cardGameList.size() == 2) {
                if (cardGameList.get(0) == cardGameList.get(1)) {
                    return cardGameList;
                } else {
                    return cardGameList;
                }
            } else if (cardGameList.size() == 1) {
                return cardGameList;
            }
            return cardGameList;
        }


        public Set<Integer> handleFlushGame(List<Integer> cardListArrange, List<Integer> figuresListArrange) {
            Multimap<Integer, Integer> cardMap = ArrayListMultimap.create();
            Set<Integer> flushCards1 = new HashSet<>();
            Set<Integer> flushCards2 = new HashSet<>();
            Set<Integer> flushCards3 = new HashSet<>();
            Set<Integer> flushCards4 = new HashSet<>();
            for (int i = 0; i < cardListArrange.size(); ) {
                for (int j = 0; j < figuresListArrange.size(); ) {
                    cardMap.put(cardListArrange.get(i), figuresListArrange.get(j));
                    i++;
                    j++;
                }
            }
            for (int i : cardMap.keySet()) {
                flushCards1.addAll(cardMap.get(100));
                flushCards2.addAll(cardMap.get(200));
                flushCards3.addAll(cardMap.get(300));
                flushCards4.addAll(cardMap.get(400));
            }

            if (flushCards1.size() >= 5) {
                return flushCards1;
            }
            if (flushCards2.size() >= 5) {
                return flushCards2;
            }
            if (flushCards3.size() >= 5) {
                return flushCards3;
            }
            if (flushCards4.size() >= 5) {
                return flushCards4;
            }
            return null;
        }

        public List<Integer> flushList(Set<Integer> flushCardSet) {
            List<Integer> flushList = new ArrayList<>(flushCardSet);
            sortMainList(flushList);
            return flushList;
        }

        public String seeStringGame(List<Integer> cardListArrange, List<Integer> figuresListArrange) {
            int counterConsecutiveCards = 1;
            int counterFirstCard = 0;
            int counterSecondCard = 0;
            int counterConsecutiveFigures = 0;


            //o lista in care practic facem diferenta dintre full si careu
            List<Integer> full = new ArrayList<>();
            List<Integer> flush = new ArrayList<>();


            //parcurgem lista cu carti
            int a = cardListArrange.get(0);
            for (int i = 1; i < cardListArrange.size(); i++) {
                if (cardListArrange.get(i) - a == counterConsecutiveCards) {
                    counterConsecutiveCards++;

                } else  if (i!=cardListArrange.size()-1 && cardListArrange.get(i).equals(cardListArrange.get(i - 1)) && cardListArrange.get(i) + 1 ==
                            (cardListArrange.get(i + 1))) {

                    }

                else {
                    a = cardListArrange.get(i);
                    if(counterConsecutiveCards<=1){
                        continue;
                    }
                    counterConsecutiveCards --;
                }
            }

            for (int i = 0; i < cardListArrange.size() - 1; i++) {
                if (cardListArrange.get(i) == cardListArrange.get(i + 1)) {
                    counterFirstCard++;
                    full.add(cardListArrange.get(i));
                }
            }

            //parcurgem lista cu figuri
            for (int i = 0; i < figuresListArrange.size() - 1; i++) {
                if (figuresListArrange.get(i).equals(figuresListArrange.get(i + 1))) {
                    flush.add(figuresListArrange.get(i));
                }
            }
            boolean isFlash = false;
            if(flush.size()>=4) {
                int reference = flush.get(0);

                for (int i = 1; i < flush.size(); i++) {
                    if (flush.get(i) == reference) {
                        counterConsecutiveFigures++;
                    } else {
                        reference = flush.get(i);
                        if (counterConsecutiveFigures != 0) {
                            counterConsecutiveFigures--;
                        }
                    }

                }
                if ((counterConsecutiveFigures >= 3 && flush.get(flush.size() - 1).equals(flush.get(flush.size() - 2))) ||
                        (counterConsecutiveFigures == 2 && flush.get(0).equals(flush.get(flush.size() - 2)))
                        || counterConsecutiveFigures == 2 && flush.get(flush.size() - 1).equals(flush.get(1)) && flush.size() > 4) {
                    isFlash = true;
                }
            }
            for (int i = 0; i < full.size() - 1; i++) {
                //[7 7 10] -> counter va fi 1 - full
                //[8 8 8] -> counter va fi 2- careu
                if (full.get(i) == full.get(i + 1)) {
                    counterSecondCard++;
                }
            }
            /**
             * comparam de acuma sa vedem care sunt jocurile in ordine importantei
             */
            //asta e quinta royala
            if (counterConsecutiveCards >= 4 && isFlash) {
                return "Quinta royala";
            } else if (counterConsecutiveCards >= 4) {
                return "Quinta";
            } else if (counterFirstCard >= 3) {
                if (counterSecondCard == 2) {
                    return "Careu";
                } else if (counterSecondCard == 1) {
                    return "Full";
                } else if (counterSecondCard == 0) {
                    return "Doua perechi";
                }
            } else if (isFlash) {
                return "Culoare";
                //aici avem jocurile care nu reprezinta ceva de acuma
            } else if (counterFirstCard == 2) {
                if (counterSecondCard == 1) {
                    return "Cui";
                } else if (counterSecondCard == 0) {
                    return "Doua perechi";
                }
            } else if (counterFirstCard == 1) {
                return "O pereche";
            } else {
                return "High card";
            }

            return "";
        }
    }






