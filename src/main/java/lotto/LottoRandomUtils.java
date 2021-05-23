package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomUtils implements CreateRandomLotto {
    private final int LOTTO_NUMBER_SIZE = 6;
    private final int LOTTO_MINIMUN_NUMBER = 1;
    private final int LOTTO_MAXIMUM_NUMBER = 45;

    private final List<Integer> lottoRange = new ArrayList<Integer>();

    public LottoRandomUtils(){
        for (int number = LOTTO_MINIMUN_NUMBER; number <= LOTTO_MAXIMUM_NUMBER; number++) {
            lottoRange.add(number);
        }
    }

    public List<Integer> createRandomLotto() {
        Collections.shuffle(lottoRange);
        List<Integer> randomLotto = new ArrayList<Integer>();
        for (int count = 0; count < LOTTO_NUMBER_SIZE; count++) {
            randomLotto.add(lottoRange.get(count));
        }
        Collections.sort(randomLotto);
        return randomLotto;
    }
}
