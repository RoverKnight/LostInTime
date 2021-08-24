package program;

import program.windows.clock.ClockInternal;
import program.windows.clock.ClockView;
import program.windows.shutdownConfirm.ShutdownConfirmView;
import program.windows.timer.TimerInternal;
import program.windows.timer.TimerView;

/**
 *  MasterInternal() is more or less a code repository which is accessed
 *  by MasterListener() when needed.
 *  Note that MasterInternal() is NOT the superclass of the other internals,
 *  because the methods that it provides are/should be accessed ONLY
 *  by a MasterListener(), as only a MasterListener() is/should be ever
 *  assigned to the general GUI elements provided by MasterView.addGeneralGUI(),
 *  for which all methods in MasterInternal() are made. Therefore, making
 *  MasterInternal() the superclass of all other internals would have no use,
 *  as other internals won't find usages for any of the methods provided.
 */
public class MasterInternal {

    public MasterView gui;

    public MasterInternal () {

    }

    public static void loadWindow (String windowType) throws IllegalArgumentException {
        MasterView oldWindow = MasterView.activeWindow;
        if (windowType.equalsIgnoreCase("clock")) {
            ClockInternal i = new ClockInternal();
            new ClockView(i);
        }
        else if (windowType.equalsIgnoreCase("timer")) {
            TimerInternal i = new TimerInternal();
            new TimerView(i);
        }
        else if (windowType.equalsIgnoreCase("shutdownConfirmation")) {
            // no internal needed because there's only 2 actions to handle
            new ShutdownConfirmView();
            return; // prevents oldWindow from being set to invisible
        }
        else throw new IllegalArgumentException();

        oldWindow.setVisible(false);
        if (oldWindow.controller != null) oldWindow.controller.interrupt();
    }

    public static void shutdown () {
        System.exit(0);
    }
}
