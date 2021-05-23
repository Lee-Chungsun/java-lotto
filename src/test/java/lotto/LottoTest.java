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

    @DisplayName("랜덤 로또 번호와 당첨 로또 번호의 일치 갯수 테스트")
    @Test
    void countRandomCollectNumber_랜덤_숫자_일치_갯수_테스트() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1,2,3,4,23,45));
        int result = lotto.countCollectNumber(new ArrayList<Integer>(Arrays.asList(1,2,3,4,23,40)));
        assertThat(result).isEqualTo(5);
    }
}
