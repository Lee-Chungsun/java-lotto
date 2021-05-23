package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    List<Lotto> listLotto;
    Lottos lottos;
    LottoBuy lottoBuy;

    @BeforeEach
    void setup() {
        listLotto = new ArrayList<Lotto>();
        lottoBuy = new LottoBuy();
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

    @DisplayName("구매 금액의 1000단위로 로또 정상 사이즈 생성 되는지 테스트")
    @ParameterizedTest(name ="{displayName}[{index}] 지불금액={0}, 로또 갯수={1}, 결과={2}")
    @CsvSource(value = {"14100:14:true", "1200:1:true", "2500:3:false"}, delimiter = ':')
    void countLotto_금액만큼_로또_생성_테스트(int pay, int lottoCount, boolean expected) {
        lottoBuy.buyLotto(pay);
        assertThat(lottoBuy.isLottoCount(lottoCount)).isEqualTo(expected);
    }

    @DisplayName("로또 구매 시 최소 금액 예외 테스트")
    @Test
    void isMinimumPay_최소_금액_예외_테스트() {
        assertThatThrownBy(() -> lottoBuy.buyLotto(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 로또 번호와 당첨 번호 비교하여 맞은 갯수 확인 테스트")
    @Test
    void countCollectNumber_일치_번호_갯수() {
        listLotto.add(new Lotto(() -> Arrays.asList(16,17,23,25,33,45)));
        lottos = new Lottos(listLotto);
        LottoResult lottoResult = lottos.compareCollectNumber(new ArrayList<Integer>(Arrays.asList(16,17,23,33,40,41)));
        assertThat(lottoResult.getThirdCount()).isEqualTo(1);
    }
}
