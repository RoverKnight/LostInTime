package program.windows.gameOfLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class - for testing & copy/pasting purposes
 */
public class GameOfLifeListener implements ActionListener {

    GameOfLifeView gui;

    public GameOfLifeListener(GameOfLifeView gui) {
        this.gui = gui;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        String testInput = gui.testInputField.getText();

        // source specific code
        if (source == gui.testButton) {
            GameOfLifeInternal.test();
        }

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
