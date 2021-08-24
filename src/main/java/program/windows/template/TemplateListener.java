package program.windows.template;

import program.windows.clock.ClockInternal;
import program.windows.clock.ClockView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class TemplateListener implements ActionListener {

    TemplateView gui;
    TemplateInternal i;

    public TemplateListener(TemplateView gui, TemplateInternal internal) {
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
