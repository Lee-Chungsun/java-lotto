package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        for(Lotto lotto : lottos) {
            lotto.checkDuplicate();
            lotto.checkLottoNumberRange();
        }
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

    public boolean isLottoCount(int lottoCount) {
        return lottoCount == lottos.size();
    }
}