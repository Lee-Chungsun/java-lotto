package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public int countCollectNumber(List<Integer> winLottoNumber) {
        int result = 0;
        for (Lotto lotto : lottos) {
            result = compareUserLottoAndWinLotto(lotto, winLottoNumber);
        }
        return result;
    }

    private int compareUserLottoAndWinLotto(Lotto lotto, List<Integer> winLottoNumber) {
        int result = 0;
        for (Integer lottoNumber : winLottoNumber) {
            result += lotto.searchCollectNumber(lottoNumber);
        }
        return result;
    }
}
