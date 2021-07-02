package generationMethods;

import java.util.List;
import java.util.Scanner;

public class AceMethod {

    public int chooseAceValue(List<Integer> intCardList) {

        int value = 0;
        if (intCardList.contains(1) || intCardList.contains(14)) {
            System.out.println("Please choose the ace value - 1 or 14");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();
            while (value != 14 && value != 1) {
                System.out.println("Wrong value for ace");
                value = scanner.nextInt();

            }
        }



        return value;
    }
}