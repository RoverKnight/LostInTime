package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  MasterListener() is the listener assigned to all the GUI elements provided
 *  by MasterView.addGeneralGUI() and triggers the appropriate action in
 *  response from MasterInternal() when an action is performed on any of the
 *  provided elements.
 *  Note that MasterListener() is NOT the superclass of the other listeners,
 *  because this would not provide any use whatsoever.
 */
public class MasterListener implements ActionListener {

    public MasterView gui;
    public MasterInternal i;

    public MasterListener (MasterView gui) {
        this.gui = gui;
    }

    public MasterListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String sourceName = ((JButton) source).getText();

        // text from buttons is used here because their variable names
        // are inaccessible
        if (sourceName.equalsIgnoreCase("Shut down") && !MasterView.shutdownWindowActive) {
            MasterInternal.loadWindow("shutdownConfirmation");
        }
        else if (sourceName.equalsIgnoreCase("Clock")) {
            MasterInternal.loadWindow("clock");
        }
        else if (sourceName.equalsIgnoreCase("Timer")) {
            MasterInternal.loadWindow("timer");
        }
        else if (sourceName.equalsIgnoreCase("RNG")) {
            MasterInternal.loadWindow("rng");
        }
        else if (sourceName.equalsIgnoreCase("File Editor")) {
            MasterInternal.loadWindow("file editor");
        }
        else if (sourceName.equalsIgnoreCase("game of life")) {
            MasterInternal.loadWindow("game of life");
        }
        else if (sourceName.equalsIgnoreCase("Tic Tac Toe")) {
            MasterInternal.loadWindow("tic tac toe");
        }
    }
}