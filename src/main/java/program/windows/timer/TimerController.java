package program.windows.timer;

import program.MasterController;

public class TimerController extends MasterController {

    TimerView gui;
    long startTime;
    long timeElapsed;
    int minutes;
    int seconds;
    int millis;
    static long lastTimeElapsed;

    public TimerController(TimerView gui, boolean resumeLast) {
        this.gui = gui;
        gui.controller = this;

        if (resumeLast) {
            startTime = System.currentTimeMillis() - lastTimeElapsed;
        }
        else {
            startTime = System.currentTimeMillis();
        }
    }

    public void run () {
        while (!isInterrupted()) {
            try {
                // waits 10 ms to update (timer only shows tens of ms, so < 10 is not needed)
                Thread.sleep(10);

                // retrieves current time values
                timeElapsed = System.currentTimeMillis() - startTime;
                minutes = getMinutes(timeElapsed) % 60;
                seconds = getTotalSeconds(timeElapsed) % 60;
                millis = getMillis(timeElapsed);

                // saves elapsed time for resume functionality
                lastTimeElapsed = timeElapsed;

                // turns time values into strings
                String minutesStr = String.valueOf(minutes);
                String secondsStr = String.valueOf(seconds);
                String millisStr = String.valueOf(millis);

                // adds "0" to time-strings if they're only single digits
                if (minutesStr.length() == 1) minutesStr = "0".concat(minutesStr);
                if (secondsStr.length() == 1) secondsStr = "0".concat(secondsStr);
                if (millisStr.length() == 1) millisStr = "0".concat(millisStr);

                // combines time-strings to single string & gives it back to gui
                String time = minutesStr+":"+secondsStr+"."+millisStr;
                gui.timerLabel.setText(time);
            }
            catch (InterruptedException ignored) {
                return;
            }
        }
    }

    public int getMinutes (long input) {

        return getTotalSeconds(input) / 60;
    }

    public int getTotalSeconds(long input) {
        return (int) input / 1000;
    }

    public int getMillis(long input) {
        return ((int) input - getTotalSeconds(input) * 1000) /10;
    }

}
