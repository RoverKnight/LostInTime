package program.windows.test;

import program.windows.clock.ClockInternal;
import program.windows.clock.ClockView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class - for testing & copy/pasting purposes
 */
public class TestListener implements ActionListener {

    TestView gui;

    public TestListener(TestView gui) {
        this.gui = gui;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        String testInput = gui.testInputField.getText();

        // source specific code
        if (source == gui.testButton) {
            TestInternal.test();
        }

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
