package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        LottoRandomNumberUtils.validationNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int countCollectNumber(List<Integer> winLottoNumber) {
        int collectCount = 0;
        for (Integer number : winLottoNumber) {
            collectCount += isCollectNumber(number);
        }
        return collectCount;
    }

    public int isCollectNumber(Integer winNumber) {
        return lottoNumber.contains(winNumber) ? 1 : 0;
    }

    public boolean lottoSize(int expectedSize) {
        return lottoNumber.size() == expectedSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}