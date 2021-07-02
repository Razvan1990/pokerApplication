package constants;

public interface CardsAndSymbols {

    public static final String[] cards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static final String [] symbols = {"Inima","Frunza","Caro","Trefla"};
    public static String message(String name1){
        return name1+" has won";
    }
    public static String message2(String name2){
        return name2+" has won";
    }

}
