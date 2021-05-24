package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto() {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumberUtils();
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(LottoRandomNumber lottoRandomNumber) {
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public int compareWinLottoNumber(List<Integer> winLottoNumber) {
        return lottoNumber.countCollectNumber(winLottoNumber);
    }

    public void compareWinLottoNumber(Lotto winLottoNumber, LottoResult lottoResult) {
        if(this.equals(winLottoNumber)){
            lottoResult.winLotto();
            return;
        }
        lottoResult.checkRank(lottoNumber.compareWinLottoNumber(winLottoNumber));
    }

    public int containNumber(Integer winNumber) {
        return lottoNumber.containNumber(winNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
