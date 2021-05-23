package lotto;

public class LottoResult {
    private static final int FIRST_COLLECT_NUMBER_COUNT = 6;
    private static final int SECOND_COLLECT_NUMBER_COUNT = 5;
    private static final int THIRD_COLLECT_NUMBER_COUNT = 4;
    private static final int FOURTH_COLLECT_NUMBER_COUNT = 3;

    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;

    public void checkRank(int collectNumberCount) {
        if(collectNumberCount == FIRST_COLLECT_NUMBER_COUNT) {
            firstCount++;
            return;
        }
        if(collectNumberCount == SECOND_COLLECT_NUMBER_COUNT) {
            secondCount++;
            return;
        }
        if(collectNumberCount == THIRD_COLLECT_NUMBER_COUNT) {
            thirdCount++;
            return;
        }
        if(collectNumberCount == FOURTH_COLLECT_NUMBER_COUNT) {
            fourthCount++;
            return;
        }
    }
    public int getFirstCount() {
        return this.firstCount;
    }

    public int getSecondCount() {
        return this.secondCount;
    }
    public int getThirdCount() {
        return this.thirdCount;
    }

    public int getFourthCount() {
        return this.fourthCount;
    }
}
