package program.windows.shutdownConfirm;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 *
 */
public class ShutdownConfirmView extends MasterView {

    // sets up reference variables for listener/internal
    ShutdownConfirmListener listener;

    // creates all gui elements
    JLabel questionLabel;
    JButton shutdownConfirmButton;
    JButton goBackButton;

    public ShutdownConfirmView() {
        // creates window
        super("LostInTime - Confirm Shutdown");

        shutdownWindowActive = true;

        // creates/assigns the listener instance
        listener = new ShutdownConfirmListener(this);

        // determines window size/layout
        setLayout(null);
        setCenteredFrameBounds(this, 360, 110);
        setStandardBackground(this);

        // creates gui
        createGUI();

        setVisible(true);
    }

    public void createGUI () {
        // TODO: window not sizing correctly (windows only... why?)
        questionLabel = new JLabel("Shut down LostInTime?", SwingConstants.CENTER);
        shutdownConfirmButton = new JButton("Yes, shut down");
        goBackButton = new JButton("No, go back");

        JButton[] buttons = {
                shutdownConfirmButton, goBackButton
        };

        // determines size/position of all gui elements
        int midX = getWidth() / 2;
        setBoundsByCC(questionLabel,         midX, 5, 250, 50);
        setBoundsByTL(shutdownConfirmButton, midX, 35, 150, 50);
        setBoundsByTR(goBackButton,          midX, 35, 150, 50);

        // styles GUI elements, adds listeners if needed & adds elements to window
        for (JButton button : buttons) {
            button.setUI(standardButtonUI);
            button.addActionListener(listener);
            add(button);
        }
        add(questionLabel);

        // updates the gui
        updateGUI();

        // makes window visible
        setVisible(true);
    }

    public void updateGUI () {

    }
}
