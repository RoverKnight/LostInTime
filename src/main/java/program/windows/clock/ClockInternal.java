package program.windows.clock;

import java.util.Calendar;

/**
 *
 */
public class ClockInternal {

    public static ClockView gui;

    static int lastMinuteValue;

    public static boolean clockWasBehind() {
        Calendar cal = Calendar.getInstance();
        int currentMinute = cal.get(Calendar.MINUTE);
        if (currentMinute != lastMinuteValue) {
            updateClock();
            lastMinuteValue = currentMinute;
            return true;
        }
        else return false;
    }

    public static void updateClock () {
        Calendar cal = Calendar.getInstance();
        String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(cal.get(Calendar.MINUTE));
        String zero = "0";

        if (hour.length() == 1) hour = zero + hour;
        if (minute.length() == 1) minute = zero + minute;

        String time = hour + ":" + minute;
        gui.clockLabel.setText(time);
    }
}
