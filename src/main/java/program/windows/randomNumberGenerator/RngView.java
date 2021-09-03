package program.windows.randomNumberGenerator;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 *
 */
public class RngView extends MasterView {

    RngListener listener;
    RngInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel resultLabel;
    JLabel statusLabel;
    JButton generateNumberButton;
    JTextField lowBoundInputField;
    JTextField highBoundInputField;
    JTextField keyInputField;

    public RngView() {
        super("LostInTime - Random Number Generator");

        // creates the listener instance
        listener = new RngListener(this, i);

        // assigns styles to vars
        buttonUI = new StyledButtonUI();

        // sets general window settings (e.g. size, layout)
        setLayout(null);
        setCenteredFrameBounds(this, 700, 450);
        setStandardBackground(this);

        // self-explanatory
        createGUI();
        setVisible(true);

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    public void createGUI () {
        // creates gui elements, assigns to vars
        resultLabel = new JLabel("Result: n/a");
        statusLabel = new JLabel("Status: Inactive");
        generateNumberButton = new JButton("Generate number");
        lowBoundInputField = new JTextField("Minimum value");
        highBoundInputField = new JTextField("Maximum value");
        keyInputField = new JTextField("Key");

        // groups some elements to simplify code
        JLabel[] labels = {
                resultLabel, statusLabel
        };
        JButton[] buttons = {
                generateNumberButton
        };
        JTextField[] inputFields = {
                lowBoundInputField, highBoundInputField,
                keyInputField
        };

        // sizes/positions elements
        setBoundsByTR(resultLabel, 650, 150, 300, 50);
        setBoundsByTR(statusLabel,          650, 50, 300, 50);
        setBoundsByTL(generateNumberButton, 50, 350, 200, 50);
        setBoundsByTL(lowBoundInputField,   50, 50, 200, 50);
        setBoundsByTL(highBoundInputField,  50, 150, 200, 50);
        setBoundsByTL(keyInputField,        50, 250, 200, 50);


        // styles / adds listeners to / adds gui elements
        for (JLabel label : labels) {
            label.setFont(ubuntuMonoB25);
            add(label);
        }
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        for (JTextField inputField : inputFields) {
            inputField.addActionListener(listener);
            inputField.setFont(ubuntuMonoI15);
            add(inputField);
        }

        // adds general GUI, updates GUI & makes window visible
        addGeneralGUI(this);
        updateGUI();
        setVisible(true);
    }

    public void setStatus (String status) {
        statusLabel.setText("Status: " + status);
    }

    public void setResult (String result) {
        resultLabel.setText("Result: " + result);
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
