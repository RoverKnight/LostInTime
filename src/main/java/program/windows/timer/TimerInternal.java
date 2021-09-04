package program.windows.timer;


/**
 *
 */
public class TimerInternal {

    public TimerView gui;

    /**
     * @param controller The timer internal to be started.
     * @param gui The window in which the timer/timer shall act.
     * @return The now active controller (should be assigned to a class' own timer
     * field, so that stopTimer() and similar methods do not throw
     * NullPointerExceptions).
     */
    public static TimerController startTimer (TimerController controller, TimerView gui) {
        if (controller == null || !controller.isAlive()) {
            // creates a timer, starts it and returns it
            controller = new TimerController(gui, false);
            controller.start();
            return controller;
        }
        else {
            System.out.println("Timer is already running");
            return null;
        }
    }

    public static void stopTimer (TimerController controller, TimerView gui) {
        while (controller.isAlive()) {
            controller.interrupt();
        }
    }

    /**
     * @param gui The window in which the timer/timer shall act.
     * @return The now active controller (should be assigned to a class' own timer
     * field, so that stopTimer() and similar methods do not throw
     * NullPointerExceptions).
     */
    public static TimerController resumeTimer (TimerView gui) {
        TimerController controller = new TimerController(gui, true);
        controller.start();

        //gui.switchStopResumeButtons();

        return controller;
    }

    public static void resetTimer (TimerView gui) {
        gui.timerLabel.setText("00:00.00");
    }

    public static void test () {
    }

}
