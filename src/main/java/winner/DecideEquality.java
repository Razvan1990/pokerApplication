package winner;

import java.util.List;
import java.util.Set;

public class DecideEquality {

    public int checkValueCardsInList(List<Integer> player1, List<Integer> player2) {
        int result = 0;
        for (int i = player1.size() - 1; i > 1; ) {
            for (int j = player2.size() - 1; j > 1; ) {
                if (player1.get(i) > player2.get(j)) {
                    return 1;
                } else if (player1.get(i) < player2.get(j)) {
                    return 2;
                } else {
                    i--;
                    j--;
                }
            }
        }
        return result;
    }
    public int checkValueCardsInCardGameList(List<Integer> player1, List<Integer> player2) {
        int result = 0;
        for (int i = player1.size() - 1; i >= 0; ) {
            for (int j = player2.size() - 1; j >= 0; ) {
                if (player1.get(i) > player2.get(j)) {
                    return 1;
                } else if (player1.get(i) < player2.get(j)) {
                    return 2;
                } else {
                    i--;
                    j--;
                }
            }
        }
        return result;
    }
}




