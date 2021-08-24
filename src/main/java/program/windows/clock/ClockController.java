package program.windows.clock;

import program.MasterController;

public class ClockController extends MasterController {

    ClockView gui;
    boolean isFirstUpdate = true;

    public ClockController(ClockView gui) {
        this.gui = gui;
    }

    public void run () {
        while (!isInterrupted()) {
            // waits for just under a minute if clock was just updated
            // to reduce strain, else waits 1s until clock needs an update
            if (gui.clockWasBehind()) {
                if (isFirstUpdate) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                        return;
                    }
                }
                else {
                    try {
                        Thread.sleep(57 * 1000);
                    } catch (InterruptedException ignored) {
                        return;
                    }
                    isFirstUpdate = false;
                }
            }
            else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                    return;
                }
            }
        }
    }
}
