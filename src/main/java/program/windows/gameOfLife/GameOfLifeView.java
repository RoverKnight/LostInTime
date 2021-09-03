package program.windows.gameOfLife;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 * Graphical interface class - for testing & copy/pasting purposes
 */
public class GameOfLifeView extends MasterView {

    GameOfLifeListener listener;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel testLabel;
    JButton testButton;
    JTextField testInputField;

    public GameOfLifeView() {
        super("LostInTime - Game of Life");

        // creates the listener instance
        listener = new GameOfLifeListener(this);

        // assigns styles to vars
        buttonUI = new StyledButtonUI();

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
            button.setUI(buttonUI);
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
        updateResponsiveGUI();
        updateTimedGUI();
    }

    public void updateResponsiveGUI () {

    }

    public void updateTimedGUI () {

    }
}
