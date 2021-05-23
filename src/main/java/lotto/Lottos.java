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

    public LottoResult compareCollectNumber(List<Integer> winLottoNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            lottoResult.checkRank(compareUserLottoAndWinLotto(lotto, winLottoNumber));
        }
        return lottoResult;
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
