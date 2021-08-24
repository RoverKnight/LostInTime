package program.windows.clock;

import program.MasterInternal;
import program.MasterListener;
import program.MasterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ClockListener implements ActionListener {

    ClockView gui;
    ClockInternal i;

    public ClockListener(ClockView gui, ClockInternal internal) {
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
