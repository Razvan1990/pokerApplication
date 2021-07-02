package games;

public class TransformGameInValue {

    public int gameTransformationInValue (String game){
        int valueGame = 0;

        switch (game){
            case "Quinta royala":
                valueGame = 9;
                break;
            case "Careu":
                valueGame = 8;
                break;
            case "Full":
                valueGame = 7;
                break;
            case "Culoare":
                valueGame = 6;
                break;
            case "Quinta":
                valueGame = 5;
                break;
            case "Cui":
                valueGame = 4;
                break;
            case "Doua perechi":
                valueGame = 3;
                break;
            case "O pereche":
                valueGame = 2;
                break;
            case "High card":
                valueGame = 1;
                break;
        }
        return valueGame;

    }
}
