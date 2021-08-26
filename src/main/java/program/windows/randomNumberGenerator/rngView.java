package program.windows.randomNumberGenerator;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

/**
 *
 */
public class rngView extends MasterView {

    rngListener listener;
    rngInternal i;

    // sets up style vars
    ButtonUI buttonUI;
    Font ubuntuMonoB25 = new Font("Ubuntu Mono", Font.BOLD, 25);
    Font getUbuntuMonoI15 = new Font("Ubuntu Mono", Font.ITALIC, 15);

    // sets up vars for gui elements
    JButton testButton;
    JLabel resultLabel;
    JLabel statusLabel;
    JButton generateNumberButton;
    JTextField lowBoundInputField;
    JTextField highBoundInputField;
    JTextField keyInputField;

    public rngView(rngInternal internal) {
        super("LostInTime - Random Number Generator");

        // assigns internal & gives it reference to this frame
        i = internal;
        i.gui = this;

        // creates the listener instance
        listener = new rngListener(this, i);

        // assigns styles to vars
        buttonUI = new StyledButtonUI();

        // sets general window settings (e.g. size, layout)
        setLayout(null);
        setCenteredFrameBounds(this, 700, 500);
        setStandardBackground(this);

        // self-explanatory
        createGUI();
        setVisible(true);

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    public void createGUI () {
        // creates gui elements, assigns to vars
        testButton = new JButton("Test");

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
                testButton, generateNumberButton
        };
        JTextField[] inputFields = {
                lowBoundInputField, highBoundInputField,
                keyInputField
        };

        // sizes/positions elements
        setBoundsByBL(testButton, 0, 500, 100, 50);

        setBoundsByTR(resultLabel, 650, 200, 300, 50);
        setBoundsByTR(statusLabel,          650, 100, 300, 50);
        setBoundsByTL(generateNumberButton, 100, 400, 200, 50);
        setBoundsByTL(lowBoundInputField,   100, 100, 200, 50);
        setBoundsByTL(highBoundInputField,  100, 200, 200, 50);
        setBoundsByTL(keyInputField,        100, 300, 200, 50);


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
            inputField.setFont(getUbuntuMonoI15);
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
