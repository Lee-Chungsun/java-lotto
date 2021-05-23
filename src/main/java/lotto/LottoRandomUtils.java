package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomUtils {
    private final List<Integer> lottoRange = new ArrayList<Integer>();

    public LottoRandomUtils(){
        for (int number = 1; number < 46; number++) {
            lottoRange.add(number);
        }
    }

    public List<Integer> createRandomLotto() {
        Collections.shuffle(lottoRange);
        List<Integer> randomLotto = new ArrayList<Integer>();
        for (int count = 0; count < 6; count++) {
            randomLotto.add(lottoRange.get(count));
        }
        Collections.sort(randomLotto);
        return randomLotto;
    }
}
