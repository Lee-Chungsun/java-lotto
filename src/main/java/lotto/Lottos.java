package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public int countCollectNumber(List<Integer> winLotto) {
        int result = 0;
        for (Lotto lotto : lottos) {
            //result += searchCollectNumber(lotto);
        }
        return result;
    }

    /*private int searchCollectNumber(Integer lotto) {
        return numberList.contains(lotto) ? 1 : 0;
    }*/
}
