package basepackage;

/**
 * onHammerSlotIdx - slot idx that will fire when method shot() will be called
 * cylinderSlots - array of 6 length, simulates revolver's cylinder. Idx that contains true simulates slot with bullet
 */

public class Revolver {
    private final boolean[] cylinderSlots = {true, true, false, false, false, false};
    private final int lastSlotIdx = cylinderSlots.length - 1;
    private int onHammerSlotIdx;

    /**
     * Method simulates revolver's shot. It returns true if shot was successful, otherwise returns false
     */
    public boolean shot() {
        boolean shotResult = cylinderSlots[onHammerSlotIdx];
        rotateAfterShot();
        return shotResult;
    }

    /**
     * Method simulates manual rotation of revolver's cylinder.
     * After it was called, onHummerSlot will be in range: 0 <= onHummerSlotIdx <= lastSlotIdx
     */
    public void rotateCylinder() {
        onHammerSlotIdx = Util.getRandomInRange(0, lastSlotIdx);
    }

    /**
     * Method needs for simulation two possible options for second player, after success outcome of first player
     */
    public void rollbackAfterShotRotation() {
        if (onHammerSlotIdx == 0) {
            onHammerSlotIdx = lastSlotIdx;
        } else {
            onHammerSlotIdx--;
        }
    }

    /**
     * Method simulates cylinder rotation after shot.
     * After it was called, onHammerSlotIdx will be incremented.
     * If onHummerSlotIdx refers to last position, it will be assigned to 0 position
     */
    private void rotateAfterShot() {
        if (onHammerSlotIdx == lastSlotIdx) {
            onHammerSlotIdx = 0;
        } else {
            onHammerSlotIdx++;
        }
    }


}
