package program.windows.randomNumberGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class RngListener implements ActionListener {

    RngView gui;
    RngInternal i;

    public RngListener(RngView gui, RngInternal internal) {
        this.gui = gui;
        i = internal;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        // (this window doesn't have text fields)

        // source specific code
        if (source == gui.generateNumberButton) {
            RngInternal.generateRandomNumber(gui);
        }

        // lets input fields keep their input
        // (this window doesn't have text fields)

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
