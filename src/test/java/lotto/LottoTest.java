package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    List<Lotto> listLotto;

    @BeforeEach
    void setup() {
        listLotto = new ArrayList<Lotto>();
    }

    @DisplayName("로또 생성 후 일급 컬렉션을 통해 당첨 번호와 일치 테스트(로또가 한장이라 가정 후 일치 갯수만 테스트)")
    @Test
    void countFirstCollectionLottoColle_로또_일급_컬렉션_사이즈_테스트() {
        listLotto.add(new Lotto(() -> Arrays.asList(16,17,23,25,33,45)));
        Lottos lottos = new Lottos(listLotto);
        int result = lottos.countCollectNumber(new ArrayList<Integer>(Arrays.asList(12,18,23,33,40,41)));
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("로또 번호 유효성(중복 번호) 체크")
    @Test
    void isLottoNumberDuplicate_중복_번호_체크() {
        listLotto.add(new Lotto(() -> Arrays.asList(16,16,23,25,33,45)));
        assertThatThrownBy(() -> new Lottos(listLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 유효성(번호 범위) 체크")
    @Test
    void isLottoNumberRange_번호_범위_체크() {
        listLotto.add(new Lotto(() -> Arrays.asList(16,17,23,25,33,50)));
        assertThatThrownBy(() -> new Lottos(listLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
