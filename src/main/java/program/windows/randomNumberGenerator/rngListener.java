package program.windows.randomNumberGenerator;

import program.windows.clock.ClockInternal;
import program.windows.clock.ClockView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class rngListener implements ActionListener {

    rngView gui;
    rngInternal i;

    public rngListener(rngView gui, rngInternal internal) {
        this.gui = gui;
        i = internal;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        // (this window doesn't have text fields)

        // source specific code


        // lets input fields keep their input
        // (this window doesn't have text fields)

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
