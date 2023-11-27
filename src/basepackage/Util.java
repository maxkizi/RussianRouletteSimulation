package basepackage;

public final class Util {
    private Util() {
    }

    public static int getRandomInRange(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }
}
