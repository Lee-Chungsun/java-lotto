package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    private static final int LOTTO_COST = 1000;
    private static final String MINIMUM_PAY_EXCEPTION_MSG = "최소금액은 " + LOTTO_COST + "원입니다.";

    private final List<Lotto> lottoList;

    private Lottos lottos;
    private int lottoCount = 0;

    public LottoMain() {
        this.lottoList = new ArrayList<>();
    }

    public void buyLotto(int pay) {
        checkMinimumPay(pay);
        this.lottoCount = pay / LOTTO_COST;
        for(int count = 0; count < lottoCount; count++) {
            lottoList.add(new Lotto(new LottoRandomUtils().createRandomLotto()));
        }
        lottos = new Lottos(lottoList);
    }

    private void checkMinimumPay(int pay) {
        if(pay < LOTTO_COST) {
            throw new IllegalArgumentException(MINIMUM_PAY_EXCEPTION_MSG);
        }
    }

    public boolean isLottoCount(int expectedLottoCount) {
        return lottos.isLottoCount(expectedLottoCount);
    }
}
