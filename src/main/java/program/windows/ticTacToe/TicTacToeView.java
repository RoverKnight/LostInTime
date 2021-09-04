package program.windows.ticTacToe;

import program.MasterView;

import javax.swing.*;

/**
 * Graphical interface class - for testing & copy/pasting purposes
 */
public class TicTacToeView extends MasterView {

    TicTacToeListener listener;

    // sets up vars for gui elements
    JLabel testLabel;
    JButton testButton;
    JTextField testInputField;

    public TicTacToeView() {
        super("LostInTime - Tic Tac Toe");

        // creates the listener instance
        listener = new TicTacToeListener(this);

        // sets general window settings (e.g. size, layout)
        setLayout(null);
        setCenteredFrameBounds(this, 700, 450);
        setStandardBackground(this);
        usableHeight = getUsableHeight();

        // self-explanatory
        createGUI();
        setVisible(true);

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    public void createGUI () {
        // creates gui elements, assigns to vars
        testLabel = new JLabel("Label", SwingConstants.CENTER);
        testButton = new JButton("Test");
        testInputField = new JTextField("Input field");

        // groups some elements to simplify code
        JButton[] buttons = {
                testButton
        };
        JLabel[] labels = {
                testLabel
        };
        JTextField[] inputFields = {
                testInputField
        };

        // sizes/positions elements
        int midY = usableHeight / 2;

        setBoundsByCC(testLabel, 350, midY, 400, 100);
        setBoundsByBL(testButton, 0, 450, 100, 50);
        setBoundsByBL(testInputField, 100, 450, 200, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(standardButtonUI);
            button.addActionListener(listener);
            add(button);
        }
        for (JLabel label : labels) {
            label.setFont(ubuntuMonoB40);
            add(label);
        }
        for (JTextField inputField : inputFields) {
            inputField.setFont(ubuntuMonoI15);
            add(inputField);
        }

        // adds general GUI, updates GUI & makes window visible
        addGeneralGUI(this);
        updateGUI();
        setVisible(true);
    }

    public void updateGUI () {

    }
}
