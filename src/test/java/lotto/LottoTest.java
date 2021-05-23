package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("일치하는 숫자의 갯수를 테스트한다")
    @Test
    void countCollectNumber_일치_숫자_갯수_테스트() {
        Lotto lotto = new Lotto(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)));
        int result = lotto.countCollectNumber(new ArrayList<Integer>(Arrays.asList(1,2,3,4,23,40)));
        assertThat(result).isEqualTo(4);
    }
}
