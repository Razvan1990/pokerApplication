package generationMethods;

import java.util.List;

public class AceRemovalList {
    public void removeUnwantedAceValueFromList(List<Integer> intListWithAces, int optionPlayer) {
        for (int i = 0; i < intListWithAces.size(); i++) {
            if (intListWithAces.contains(1) || intListWithAces.contains(14)) {
                switch (optionPlayer) {
                    case 1:
                        intListWithAces.removeIf(value -> value == 14);
                        break;
                    case 15:
                        intListWithAces.removeIf(value -> value == 1);
                        break;
                }
            }
        }
    }
}
