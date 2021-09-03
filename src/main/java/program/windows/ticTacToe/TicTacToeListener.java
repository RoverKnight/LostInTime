package program.windows.ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class - for testing & copy/pasting purposes
 */
public class TicTacToeListener implements ActionListener {

    TicTacToeView gui;

    public TicTacToeListener(TicTacToeView gui) {
        this.gui = gui;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        String testInput = gui.testInputField.getText();

        // source specific code
        if (source == gui.testButton) {
            TicTacToeInternal.test();
        }

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
