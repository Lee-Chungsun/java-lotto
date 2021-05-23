package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final int LOTTO_NUMBER_SIZE = 6;
    private final int LOTTO_MINIMUN_NUMBER = 1;
    private final int LOTTO_MAXIMUM_NUMBER = 45;

    private final String DUPLICATE_EXCEPTION_MSG = "중복 숫자는 입력할 수 없습니다.";
    private final String RANGE_EXCEPTION_MSG = "숫자는 1부터 45까지의 숫자만 허용됩니다.";

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

    public void checkDuplicate() {
        Set<Integer> checkSet = new HashSet<>(lottoNumber);
        if(checkSet.size() < LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(lottoNumber.toString() + " " + DUPLICATE_EXCEPTION_MSG);
        }
    }

    public void checkLottoNumberRange() {
        lottoNumber.forEach(number -> checkRange(number));
    }

    private void checkRange(Integer number) {
        if(number < LOTTO_MINIMUN_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(lottoNumber.toString() + " " + RANGE_EXCEPTION_MSG);
        }
    }
}
