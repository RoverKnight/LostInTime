package program.windows.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class TimerListener implements ActionListener {

    TimerView gui;
    TimerInternal i;
    TimerController controller = null; // TODO: rename to timer (maybe even whole class)?

    public TimerListener(TimerView gui, TimerInternal internal) {
        this.gui = gui;
        i = internal;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        // (this window doesn't have text fields)

        // source specific code
        if (source == gui.startButton) {
            controller = TimerInternal.startTimer(controller, gui);
        }
        else if (source == gui.stopButton) {
            controller = TimerInternal.stopTimer(controller, gui);
        }
        else if (source == gui.resetButton) {
            TimerInternal.resetTimer(gui);
        }
        else if (source == gui.testButton) {
            TimerInternal.test();
        }
        else if (source == gui.resumeButton) {
            controller = TimerInternal.resumeTimer(gui);
        }

        // gives back modified updater to gui
        gui.controller = controller;

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}