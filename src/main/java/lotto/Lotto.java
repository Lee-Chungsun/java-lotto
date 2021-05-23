package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto(CreateRandomLotto lottoRandom) {
        this.lottoNumber = lottoRandom.createRandomLotto();
    }

    public Lotto(List<Integer> numberList) {
        this.lottoNumber = numberList;
    }

    public int searchCollectNumber(Integer lotto) {
        return lottoNumber.contains(lotto) ? 1 : 0;
    }
}
