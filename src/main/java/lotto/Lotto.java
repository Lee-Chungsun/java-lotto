package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public int countCollectNumber(List<Integer> winLotto) {
        int result = 0;
        for (Integer lotto : winLotto) {
            result += searchCollectNumber(lotto);
        }
        return result;
    }

    private int searchCollectNumber(Integer lotto) {
        return numberList.contains(lotto) ? 1 : 0;
    }
}
