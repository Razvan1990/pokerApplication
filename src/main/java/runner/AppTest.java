package runner;

import com.google.common.collect.Multimap;
import constants.CheckingCardFigurePresent;
import constants.Generics;
import games.SkeletonGamesToConditions;
import games.TransformGameInValue;
import generationMethods.AceMethod;
import generationMethods.AceRemovalList;
import generationMethods.CardGeneration;
import transformerPackage.ListToList;
import transformerPackage.MapToList;
import winner.CheckWinner;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppTest {
    public void manageGameFunction() {


    /**
     * --------------------------------------------------------------------------------------------------------------
     * STEP 1 - GENERATION ALL CARDS, SHOWING THEM AND ADDING THEM IN COLLECTIONS
     * --------------------------------------------------------------------------------------------------------------
     */
    /**
     * TODO


     */

    //
    //objects creation
    CardGeneration cardGeneration = new CardGeneration();
    MapToList tranformerMapToList = new MapToList();
    ListToList listToList = new ListToList();
    Generics generics = new Generics();
    CheckingCardFigurePresent checkingCardFigurePresent = new CheckingCardFigurePresent();
    AceMethod aceMethod = new AceMethod();
    AceRemovalList aceRemoveList = new AceRemovalList();
    SkeletonGamesToConditions skeletonGamesToConditions = new SkeletonGamesToConditions();
    TransformGameInValue transformGameInValue = new TransformGameInValue();
    CheckWinner checkWinner = new CheckWinner();
/**
 * PREZENTARE PROGRAM SI ALEGERE NUME JUCATORI
 */
        System.out.println("Welcome to the POKER APP in which we will simulate a heads-up . Please first put your names");
        System.out.println("Player 1 name is ");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        System.out.println("Player 2 name is ");
        String name2 = scanner.next();



        System.out.println("###If you see something like 2[Ininma, Trefla] 2[Inima, Trefla], then you have 2[Inima] and 2[Trefla] ###");
        System.out.println("");
        System.out.println(name1+" cards: ");

    String card1Player1 = cardGeneration.generateRandomCard();
    String figure1Player1 = cardGeneration.generateRandomFigure();
    Multimap<String, String> cardMapPlayer1 = cardGeneration.playersCard(card1Player1, figure1Player1);
    //cardGeneration.showCard(cardMapPlayer1);


    String card2Player1 = cardGeneration.generateRandomCard();
    String figure2Player1 = cardGeneration.generateRandomFigure();

    boolean checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(card2Player1, figure2Player1, cardMapPlayer1);

        while(checkCard)

    {
        System.out.println("Regenerating card");
        card2Player1 = cardGeneration.generateRandomCard();
        figure2Player1 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(card2Player1, figure2Player1, cardMapPlayer1);
    }
    //metoda de pus in map
        cardGeneration.addCard(card2Player1,figure2Player1,cardMapPlayer1);
        try{
            Thread thread = new Thread();
            thread.sleep(1500);
        }catch(Exception e){
            e.printStackTrace();
        }
        cardGeneration.showCard(cardMapPlayer1);


//        tranformerMapToList.showCardList(cards);
//        tranformerMapToList.showCardList(figures);
//        System.out.println();


    //generare element pentru al doilea player
        System.out.println();


    String card1Player2 = cardGeneration.generateRandomCard();
    String figure1Player2 = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(card1Player2,figure1Player2,cardMapPlayer1);
        System.out.println(name2+" cards: ");


        while(checkCard)

    {
        System.out.println("Regenerating card");
        card1Player2 = cardGeneration.generateRandomCard();
        figure1Player2 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(card1Player2, figure1Player2, cardMapPlayer1);
    }

    Multimap<String, String> cardMapPlayer2 = cardGeneration.playersCard(card1Player2, figure1Player2);
    // cardGeneration.showCard(cardMapPlayer2);

    //generarea de liste  String pentru player2


    //generare a doua carte pentru player2

    String card2Player2 = cardGeneration.generateRandomCard();
    String figure2Player2 = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(card2Player2,figure2Player2,cardMapPlayer1);

        while(checkCard ||(card2Player2.equals(card1Player2)&&(figure2Player2.equals(figure1Player2))))

    {
        card2Player2 = cardGeneration.generateRandomCard();
        figure2Player2 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(card2Player2, figure2Player2, cardMapPlayer1);

    }
        cardGeneration.addCard(card2Player2,figure2Player2,cardMapPlayer2);

        try{
            Thread thread = new Thread();
            thread.sleep(1500);

        }catch(Exception e){
            e.printStackTrace();
        }
        cardGeneration.showCard(cardMapPlayer2);


    //transformare in liste de ints

    //List<Integer> cardIntegerListPlayer2 = listToList.cardsToIntList(cardsListPlayer2,"player2");
    //List<Integer> figuresIntegerListPlayer2 = listToList.figuresToIntList(figuresListPlayer2, "player2");
    // generics.printList(cardIntegerListPlayer2);
    //generics.printList(figuresIntegerListPlayer2);



        /*
        continuam cu generare de carte noua si verificam cu metoda in ambele mape acuma si adaugam in ambele list aceasta carte
         /*
        Flop generation and showing
         */


        System.out.println("");;
        System.out.println("The flop");
    String flopCard1 = cardGeneration.generateRandomCard();
    String flopFigure1 = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(flopCard1,flopFigure1,cardMapPlayer1);
    boolean checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard1, flopFigure1, cardMapPlayer2);

       while(checkCard ||checkCard2)

    {
        System.out.println("Regenerating card");
        flopCard1 = cardGeneration.generateRandomCard();
        flopFigure1 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard1, flopFigure1, cardMapPlayer1);
        checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard1, flopFigure1, cardMapPlayer2);
    }

    Multimap<String, String> flopMapCard1 = cardGeneration.playersCard(flopCard1, flopFigure1);

        cardGeneration.addCard(flopCard1,flopFigure1,cardMapPlayer1);
        cardGeneration.addCard(flopCard1,flopFigure1,cardMapPlayer2);


    //cardGeneration.showCard(cardMapPlayer1);
    //System.out.println("-----------------");
    //cardGeneration.showCard(cardMapPlayer2);

    String flopCard2 = cardGeneration.generateRandomCard();
    String flopFigure2 = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(flopCard2,flopFigure2,cardMapPlayer1);
    checkCard2 =checkingCardFigurePresent.checkToSeeIfCardExists(flopCard2,flopFigure2,cardMapPlayer2);

        while(checkCard ||checkCard2)

    {
        System.out.println("Regenerating card");
        flopCard2 = cardGeneration.generateRandomCard();
        flopFigure2 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard2, flopFigure2, cardMapPlayer1);
        checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard2, flopFigure2, cardMapPlayer2);
    }

    Multimap<String, String> flopMapCard2 = cardGeneration.playersCard(flopCard2, flopFigure2);
        cardGeneration.addCard(flopCard2,flopFigure2,cardMapPlayer1);
        cardGeneration.addCard(flopCard2,flopFigure2,cardMapPlayer2);

    String flopCard3 = cardGeneration.generateRandomCard();
    String flopFigure3 = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(flopCard3,flopFigure3,cardMapPlayer1);
    checkCard2 =checkingCardFigurePresent.checkToSeeIfCardExists(flopCard3,flopFigure3,cardMapPlayer2);

        while(checkCard ||checkCard2)

    {
        System.out.println("Regenerating card");
        flopCard3 = cardGeneration.generateRandomCard();
        flopFigure3 = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard3, flopFigure3, cardMapPlayer1);
        checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(flopCard3, flopFigure3, cardMapPlayer2);
    }

    Multimap<String, String> flopMapCard3 = cardGeneration.playersCard(flopCard3, flopFigure3);
        cardGeneration.addCard(flopCard3,flopFigure3,cardMapPlayer1);
        cardGeneration.addCard(flopCard3,flopFigure3,cardMapPlayer2);
        try{
            Thread thread = new Thread();
            thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        cardGeneration.showCard(flopMapCard1); cardGeneration.showCard(flopMapCard2);cardGeneration.showCard(flopMapCard3);

/*
Turn card generation and showing
 */
        System.out.println("");
        System.out.println("Here comes the turn card..");
    String turnCard = cardGeneration.generateRandomCard();
    String turnFigure = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(turnCard ,turnFigure,cardMapPlayer1);
    checkCard2 =checkingCardFigurePresent.checkToSeeIfCardExists(turnCard ,turnFigure,cardMapPlayer2);

        while(checkCard ||checkCard2)

    {
        System.out.println("Regenerating card");
        turnCard = cardGeneration.generateRandomCard();
        turnFigure = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(turnCard, turnFigure, cardMapPlayer1);
        checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(turnCard, turnFigure, cardMapPlayer2);
    }

    Multimap<String, String> turnMapCard = cardGeneration.playersCard(turnCard, turnFigure);
        cardGeneration.addCard(turnCard ,turnFigure,cardMapPlayer1);
        cardGeneration.addCard(turnCard ,turnFigure,cardMapPlayer2);
        try{
            Thread thread = new Thread();
            thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
        cardGeneration.showCard(turnMapCard);

        /*
        River card generation and showing
         */
        System.out.println("");
        System.out.println("And now the river..");
    String riverCard = cardGeneration.generateRandomCard();
    String riverFigure = cardGeneration.generateRandomFigure();

    checkCard =checkingCardFigurePresent.checkToSeeIfCardExists(riverCard ,riverFigure,cardMapPlayer1);
    checkCard2 =checkingCardFigurePresent.checkToSeeIfCardExists(riverCard ,riverFigure,cardMapPlayer2);

        while(checkCard ||checkCard2)

    {
        System.out.println("Regenerating card");
        riverCard = cardGeneration.generateRandomCard();
        riverFigure = cardGeneration.generateRandomFigure();
        checkCard = checkingCardFigurePresent.checkToSeeIfCardExists(riverCard, riverFigure, cardMapPlayer1);
        checkCard2 = checkingCardFigurePresent.checkToSeeIfCardExists(riverCard, riverFigure, cardMapPlayer2);
    }

    Multimap<String, String> riverMapCard = cardGeneration.playersCard(riverCard, riverFigure);
        cardGeneration.addCard(riverCard ,riverFigure,cardMapPlayer1);
        cardGeneration.addCard(riverCard,riverFigure,cardMapPlayer2);
        try{
            Thread thread = new Thread();
            thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }

        cardGeneration.showCard(riverMapCard);
        System.out.println("");

    //   System.out.println("Player 1 final cards: ");cardGeneration.showCard(cardMapPlayer1);
    // System.out.println("");
    // System.out.println("Player 2 final cards: ");cardGeneration.showCard(cardMapPlayer2);


    /**
     * --------------------------------------------------------------------------------------------------------------
     * STEP 2 - Insert the cards from the map into a string list and create from the String List an Integer List
     * --------------------------------------------------------------------------------------------------------------
     */
    List<String> cardListPlayer1 = tranformerMapToList.cardList(cardMapPlayer1);
    List<String> figuresListPlayer1 = tranformerMapToList.figuresList(cardMapPlayer1);

    List<String> cardListPlayer2 = tranformerMapToList.cardList(cardMapPlayer2);
    List<String> figuresListPlayer2 = tranformerMapToList.figuresList(cardMapPlayer2);
    // cardListPlayer1 = tranformerMapToList.addCardsInList(cardListPlayer1,card2Player1);
    //figuresListPlayer1 = tranformerMapToList.addFiguresList(figuresListPlayer1, figure2Player1);


    //transform the string list into an int list for player1
    List<Integer> cardIntegerListPlayer1 = listToList.cardsToIntList(cardListPlayer1, name1);
    //redundant second parameter, but it is kept for visibility of program
    List<Integer> figuresIntegerListPlayer1 = listToList.figuresToIntList(figuresListPlayer1, name1);

    //transform the string list into an int list for player1
    List<Integer> cardIntegerListPlayer2 = listToList.cardsToIntList(cardListPlayer2, name2);
    List<Integer> figuresIntegerListPlayer2 = listToList.figuresToIntList(figuresListPlayer2, name2);

    //generics.printList(cardIntegerListPlayer1);
    //generics.printList(cardIntegerListPlayer2);
        System.out.println("");
    // generics.printList(figuresIntegerListPlayer1);
    //check to see if Ace in list
        System.out.println("If player1 has ace..");
    int aceOption = aceMethod.chooseAceValue(cardIntegerListPlayer1);
        aceRemoveList.removeUnwantedAceValueFromList(cardIntegerListPlayer1,aceOption);
    //generics.printList(cardIntegerListPlayer1);
        System.out.println("If player2 has ace..");
    int aceOption2 = aceMethod.chooseAceValue(cardIntegerListPlayer2);
        aceRemoveList.removeUnwantedAceValueFromList(cardIntegerListPlayer2,aceOption2);

    /**
     * --------------------------------------------------------------------------------------------------------------
     * STEP 3 - Based on the int list, transform the games see the games in the int list and produce a string
     * with game from list then transform it back into a int value
     * --------------------------------------------------------------------------------------------------------------
     */

    //create a new list to arrange the existing lists for player1

    List<Integer> player1ArrangedCardIntList = skeletonGamesToConditions.sortMainList(cardIntegerListPlayer1);
    List<Integer> player1ArrangedFiguresIntList = skeletonGamesToConditions.sortMainList(figuresIntegerListPlayer1);
        System.out.println("");
    List<Integer> player2ArrangedCardIntList = skeletonGamesToConditions.sortMainList(cardIntegerListPlayer2);
    List<Integer> player2ArrangedFiguresIntList = skeletonGamesToConditions.sortMainList(figuresIntegerListPlayer2);
//===important pentru a putea vedea cartile din lista si a face debug===
    //        generics.printList(player1ArrangedCardIntList);
//        generics.printList(player1ArrangedFiguresIntList);
//        System.out.println("");
//        generics.printList(player2ArrangedCardIntList);
//        generics.printList(player2ArrangedFiguresIntList);

    //create the existing lists for comparing everything in the final
// no needs - it is being appealed in the method
    List<Integer> player1CardGames = skeletonGamesToConditions.addCardsOfGameInList(player1ArrangedCardIntList);
    List<Integer> player2CardGames = skeletonGamesToConditions.addCardsOfGameInList(player2ArrangedCardIntList);

    //create the Sets for checking the Flash

    // Set<Integer> player1FlushCardSet = skeletonGamesToConditions.handleFlushGame(player1ArrangedCardIntList,player1ArrangedFiguresIntList);
    // Set<Integer> player2FlushCardSet = skeletonGamesToConditions.handleFlushGame(player2ArrangedCardIntList,player2ArrangedFiguresIntList);

    //create new lists to transform the set into a list
    //no needs - insert this in checkWinner

//        if(player1FlushCardSet!=null) {
//            List<Integer> player1FlushList = skeletonGamesToConditions.flushList(player1FlushCardSet);
//        }
//        if(player2FlushCardSet!=null) {
//            List<Integer> player2FlushList = skeletonGamesToConditions.flushList(player2FlushCardSet);
//        }
    //set the string name of the game

    String player1Game = skeletonGamesToConditions.seeStringGame(player1ArrangedCardIntList, player1ArrangedFiguresIntList);
    String player2Game = skeletonGamesToConditions.seeStringGame(player2ArrangedCardIntList, player2ArrangedFiguresIntList);

    //transform the string into values

    int player1Score = transformGameInValue.gameTransformationInValue(player1Game);
    int player2Score = transformGameInValue.gameTransformationInValue(player2Game);

    /**
     * --------------------------------------------------------------------------------------------------------------
     * STEP 4 - We appeal the method from checkWinner, using all the informations we have integrated in variables:
     * -arrangedListCard, arrangedListFigure, arrangeListPlayer1, arrangeListPlayer2, player1Score, player2Score
     * --------------------------------------------------------------------------------------------------------------
     */
        System.out.println("Dealer says....");
        try{
            Thread thread = new Thread();
            thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

    String winner = checkWinner.checkWinnerOfGame(player1Score, player2Score, player1ArrangedCardIntList, player2ArrangedCardIntList,
            player1ArrangedFiguresIntList, player2ArrangedFiguresIntList,name1,name2);
        System.out.println(winner);
}
}