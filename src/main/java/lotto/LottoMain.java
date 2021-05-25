package lotto;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyLotto(inputView.payForLotto());
        ResultView.buyLottoInfo(lottos);

        LottoResult lottoResult = lottos.compareWinNumber(inputView.inputWinLottoNumber());

        ResultView resultView = new ResultView();
        resultView.prinfResult(lottoResult);
    }
}
