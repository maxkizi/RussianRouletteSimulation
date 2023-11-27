package basepackage;

public class StatisticCollector {
    private final long experimentTotalCount;
    long player1FailedCount;
    long player2ImmediatelyAndFailedCount;
    long player2RotateAndFailedCount;


    public StatisticCollector(long experimentTotalCount) {
        this.experimentTotalCount = experimentTotalCount;
    }

    public void printStatistic() {
        // Calculate player 1 success outcomes count.
        long player1SuccessCount = experimentTotalCount - player1FailedCount;
        // Calculate player 1 success percent.
        byte player1SuccessPercent = (byte) (player1SuccessCount * 100 / experimentTotalCount);

        // NOTE: Player 1 success outcomes equals total player 2 count. It is obvious :).
        long player2TotalCount = player1SuccessCount;

        // Calculate player 2 success outcomes after rotation
        long player2SuccessAfterRotationCount = player2TotalCount - player2RotateAndFailedCount;
        // Calculate player 2 success outcomes after rotation percent
        byte player2SuccessAfterRotationPercent = (byte) (player2SuccessAfterRotationCount * 100 / player2TotalCount);

        //Calculate player 2 success outcomes if he shot immediately
        long player2ImmediatelyAndSuccessCount = player2TotalCount - player2ImmediatelyAndFailedCount;
        //Calculate player 2 immediately shot success outcomes percent
        byte player2ImmediatelyAndSuccessPercent = (byte) (player2ImmediatelyAndSuccessCount * 100 / player2TotalCount);
        System.out.println("Кол-во экспериментов: " + this.experimentTotalCount );
        System.out.println("Кол-во и процент успешных исходов первого игрока: " + player1SuccessCount + ", " + player1SuccessPercent + "%");
        System.out.println("Кол-во и процент успешных исходов второго игрока для случия \"крутить\": " + player2SuccessAfterRotationCount + ", " + player2SuccessAfterRotationPercent + "%");
        System.out.println("Кол-во и процент успешных исходов второго игрока для случия \"нажать\": " + player2ImmediatelyAndSuccessCount + ", " + player2ImmediatelyAndSuccessPercent + "%");
    }
}
