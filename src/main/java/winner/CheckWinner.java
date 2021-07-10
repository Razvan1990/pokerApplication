package winner;

import constants.CardsAndSymbols;
import games.SkeletonGamesToConditions;

import java.util.List;
import java.util.Set;

public class CheckWinner {

    public String checkWinnerOfGame(int valuePlayer1, int valuePlayer2, List<Integer> player1ArrangedList, List<Integer> player2ArrangedList,
                                    List<Integer> player1FiguesListArrange, List<Integer> player2FiguesListArrange,
                                    String namePLayer1, String namePlayer2) {
        SkeletonGamesToConditions skeletonGamesToConditions = new SkeletonGamesToConditions();
        DecideEquality decideEquality = new DecideEquality();
        List<Integer> cardGameListPlayer1 = skeletonGamesToConditions.addCardsOfGameInList(player1ArrangedList);
        List<Integer> cardGameListPlayer2 = skeletonGamesToConditions.addCardsOfGameInList(player2ArrangedList);

        if (valuePlayer1 > valuePlayer2) {
            switch (valuePlayer1) {
                case 9:
                    return CardsAndSymbols.message(namePLayer1)+" . Wow! Straight flush ";
                case 8:
                    return CardsAndSymbols.message(namePLayer1) + " . Nice cards! 4 of a kind ";
                case 7:
                    return CardsAndSymbols.message(namePLayer1)+ " . Excellent hand! Full house";
                case 6:
                    return CardsAndSymbols.message(namePLayer1) + " . Good hand! Flush";
                case 5:
                    return CardsAndSymbols.message(namePLayer1) + " . Nice hand!  Straight";
                case 4:
                    return CardsAndSymbols.message(namePLayer1)+ " . Good hand!  3 of a kind";
                case 3:
                    return CardsAndSymbols.message(namePLayer1) + " . Nice!  2 pairs";
                case 2:
                    return CardsAndSymbols.message(namePLayer1)+ " . You snatch it!  1 pair";
            }
        } else if (valuePlayer1 < valuePlayer2) {
            switch (valuePlayer2) {
                case 9:
                    return CardsAndSymbols.message2(namePlayer2) + " . Wow! Straight flush ";
                case 8:
                    return CardsAndSymbols.message2(namePlayer2)+ " . Nice cards! 4 of a kind ";
                case 7:
                    return CardsAndSymbols.message2(namePlayer2)+ " . Excellent hand! Full house";
                case 6:
                    return CardsAndSymbols.message2(namePlayer2) + " . Good hand! Flush";
                case 5:
                    return CardsAndSymbols.message2(namePlayer2)+ " . Nice hand!  Straight";
                case 4:
                    return CardsAndSymbols.message2(namePlayer2) + " . Good hand!  3 of a kind";
                case 3:
                    return CardsAndSymbols.message2(namePlayer2) + " . Nice!  2 pairs";
                case 2:
                    return CardsAndSymbols.message2(namePlayer2)+ " . You snatch it!  1 pair";
            }
        } else {
        /*
        Royala
         */
            if (valuePlayer1 == 9) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1) + " . The straight flush from " +namePLayer1+ " is higher";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + " . The straight flush from " +namePlayer2+" is higher";
                } else {
                    //de safety este aceasta. Nu putem avea amandoi chinta royala decat daca e jos
                    return "Split! You both have straight flush ";
                }
            }
            /*
            Careu
             */
            else if (valuePlayer1 == 8) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1)+ " . 4 of a kind from "+namePLayer1+ " is with a bigger card";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + " . 4 of a kind from "+namePlayer2+ " is with a bigger card";
                } else {
                    int bigKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 1);
                    int bigKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 1);
                    if (bigKicker1 == bigKicker2 && bigKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1)) {
                        return "Split! You both have 4 of a kind";
                    } else {
                        int comparisionResult2 = decideEquality.checkValueCardsInList(player1ArrangedList, player2ArrangedList);
                        if (comparisionResult2 == 1) {
                            return CardsAndSymbols.message(namePLayer1) + " . You both have the same 4 of a kind, but " +namePLayer1+ " has a bigger kicker";
                        } else if (comparisionResult2 == 2) {
                            return CardsAndSymbols.message2(namePlayer2) + " . You both have the same 4 of a kind, but "+namePlayer2+ " has a bigger kicker";
                        }
                    }


                }
                /*
                Full
                 */
            } else if (valuePlayer1 == 7) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1) + " . Full House from "+namePLayer1+" is with a bigger card";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2)+ " . Full house from "+namePlayer2+" is with a bigger card";
                } else {
                    return "Split! You both have same Full house ";
                }
                /*
                Culoarea
                 */
            } else if (valuePlayer1 == 6) {
                Set<Integer> flushSetPlayer1 = skeletonGamesToConditions.handleFlushGame(player1ArrangedList, player2FiguesListArrange);
                Set<Integer> flushSetPlayer2 = skeletonGamesToConditions.handleFlushGame(player2ArrangedList, player2FiguesListArrange);
                List<Integer> flushListPlayer1 = skeletonGamesToConditions.flushList(flushSetPlayer1);
                List<Integer> flushListPlayer2 = skeletonGamesToConditions.flushList(flushSetPlayer2);
                
                int comparisionResult = decideEquality.checkValueCardsInList(flushListPlayer1, flushListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1)+ " . Flush from "+namePLayer1+" is with a bigger card";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + " . Flush from "+namePlayer2+" is with a bigger card";
                } else {
                    return "Split! You both have same flush";
                }
            /*
            Chinta
             */
            } else if (valuePlayer1 == 5) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1) + " . Straight from "+ namePLayer1+" is with a bigger card";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2)+ " . Straight from "+namePlayer2+"  is  with a bigger card";
                } else {
                    return "Split! You both have same Straight";
                }
                /*
                Cui
                 */
            } else if (valuePlayer1 == 4) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1)+ " . The 3 of a kind from "+namePLayer1+ " is bigger";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2)+ " . The 3 of a kind from "+namePlayer2+ " is bigger";
                } else {
                    int firstKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 1);
                    int firstKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 1);
                    int secondKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 2);
                    int secondKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 2);
                    if ((firstKicker1 == firstKicker2 && firstKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1)) &&
                            (secondKicker1 == secondKicker2 && secondKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1))) {
                        return "Split! You both have same 3 of a kind and your kickers are the same";
                    }
                    int comparisionResult2 = decideEquality.checkValueCardsInList(player1ArrangedList, player2ArrangedList);
                    if (comparisionResult2 == 1) {
                        return CardsAndSymbols.message(namePLayer1) + " . You both have the same 3 of a kind, but "+namePLayer1+" has a bigger kicker";
                    } else if (comparisionResult2 == 2) {
                        return CardsAndSymbols.message2(namePlayer2) + " . You both have the same 3 of a kind, but "+namePlayer2+" has a bigger kicker";
                    }
                }

                /*
                2 perechi
                 */
            } else if (valuePlayer1 == 3) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1)+". " +namePLayer1+ " has a bigger pair from the two";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + ". "+namePlayer2+ "has a bigger pair from the two";
                } else {
                    int bigKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 1);
                    int bigKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 1);
                    if (bigKicker1 == bigKicker2 && bigKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1)) {
                        return "Split! You both have 2 pairs and the kicker is the same";
                    } else {
                        int comparisionResult2 = decideEquality.checkValueCardsInList(player1ArrangedList, player2ArrangedList);
                        if (comparisionResult2 == 1) {
                            return CardsAndSymbols.message(namePLayer1) + " . You both have 2 pairs but "+namePLayer1+ " has a bigger kicker";
                        } else if (comparisionResult2 == 2) {
                            return CardsAndSymbols.message2(namePlayer2) + " . You both have 2 pairs but "+namePlayer2+" has a bigger kicker";
                        }
                    }
                }

            } else if (valuePlayer1 == 2) {
                int comparisionResult = decideEquality.checkValueCardsInList(cardGameListPlayer1, cardGameListPlayer2);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1) + " ."+namePLayer1+" has a bigger pair from the two";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + " ."+namePlayer2+" has a bigger pair from the two";
                } else {
                    int firstKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 1);
                    int firstKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 1);
                    int secondKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 2);
                    int secondKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 2);
                    int thirdKicker1 = player1ArrangedList.get(player1ArrangedList.size() - 3);
                    int thirdKicker2 = player2ArrangedList.get(player2ArrangedList.size() - 3);
                    if ((firstKicker1 == firstKicker2 && firstKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1)) &&
                            (secondKicker1 == secondKicker2 && secondKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1)) &&
                            (thirdKicker1 == thirdKicker2 && thirdKicker1 > cardGameListPlayer1.get(cardGameListPlayer1.size() - 1))) {
                        return "Split! You both have 2 small pairs!";
                    } else {
                        int comparisionResult2 = decideEquality.checkValueCardsInList(player1ArrangedList, player2ArrangedList);
                        if (comparisionResult2 == 1) {
                            return CardsAndSymbols.message(namePLayer1) + " . You both have 1 pair but "+ namePLayer1 +" has a bigger kicker";
                        } else if (comparisionResult2 == 2) {
                            return CardsAndSymbols.message2(namePlayer2) + " . You both have 1 pair but "+ namePlayer2+" has a bigger kicker";
                        }
                    }
                }
            } else if (valuePlayer1 == 1) {
                int comparisionResult = decideEquality.checkValueCardsInList(player1ArrangedList, player2ArrangedList);
                if (comparisionResult == 1) {
                    return CardsAndSymbols.message(namePLayer1)+ " ."+namePLayer1+" has a bigger kicker";
                } else if (comparisionResult == 2) {
                    return CardsAndSymbols.message2(namePlayer2) + " ."+namePlayer2+" has a bigger kicker";
                } else {
                    return "Split! You both have bad cards!";
                }
            }
        }
        return " ";
    }
}
