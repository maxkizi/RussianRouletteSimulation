package basepackage;

public class RussianRouletteSimulation {
    public static void main(String[] args) {
        long experimentCount = Long.parseLong(args[0]);


        Revolver revolver = new Revolver();
        StatisticCollector statisticCollector = new StatisticCollector(experimentCount);

        for (int i = 1; i < experimentCount; i++) {
            //Start of experiment - first player rotates revolver's cylinder
            revolver.rotateCylinder();

            // First player shots. If revolver shot success - then experiment done
            if (revolver.shot()) {
                statisticCollector.player1FailedCount++;
                continue;
            }
            // Second player shots immediately
            if (revolver.shot()) {
                statisticCollector.player2ImmediatelyAndFailedCount++;
            }

            // Rollback revolver to after first player shot state
            revolver.rollbackAfterShotRotation();

            // Second player rotate cylinder and shot
            revolver.rotateCylinder();
            if (revolver.shot()) {
                statisticCollector.player2RotateAndFailedCount++;
            }
        }
        statisticCollector.printStatistic();
    }
}
