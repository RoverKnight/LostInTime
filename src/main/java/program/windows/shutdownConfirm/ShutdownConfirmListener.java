package program.windows.shutdownConfirm;

import program.MasterInternal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class ShutdownConfirmListener implements ActionListener {

    ShutdownConfirmView gui;

    public ShutdownConfirmListener(ShutdownConfirmView gui) {
        this.gui = gui;
    }

    public void actionPerformed (ActionEvent e) {
        // gets the events source
        Object source = e.getSource();

        // source specific code
        if (source == gui.shutdownConfirmButton) {
            MasterInternal.shutdown();
        }
        else if (source == gui.goBackButton) {
            gui.setVisible(false);
            gui.shutdownWindowActive = false;
        }

        // updates the GUI
        gui.updateGUI();
    }
}
