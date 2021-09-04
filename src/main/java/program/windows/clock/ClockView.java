package program.windows.clock;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 *
 */
public class ClockView extends MasterView {

    ClockListener listener;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel clockLabel;
    JButton testButton;

    public ClockView () {
        super("LostInTime - Clock");

        // creates the listener instance
        listener = new ClockListener(this);

        // gives internal reference to this frame
        ClockInternal.gui = this;

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

        // creates a clock updater & starts it (must be after createGUI()!)
        controller = new ClockController(this);
        controller.start();

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    public void createGUI () {
        // creates gui elements, assigns to vars
        clockLabel = new JLabel("00:00", SwingConstants.CENTER);
        testButton = new JButton("Test");

        // groups some elements to simplify code
        JButton[] buttons = {
            testButton
        };

        // sizes/positions elements
        int midY = usableHeight / 2;

        setBoundsByCC(clockLabel, 350, midY-15, 400, 100);
        setBoundsByBL(testButton, 0, 450, 100, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        clockLabel.setFont(ubuntuMonoB40);

        add(clockLabel);
        add(testButton);

        // adds general GUI, updates GUI & makes window visible
        addGeneralGUI(this);
        updateGUI();
        setVisible(true);
    }

    public void updateGUI () {
        ClockInternal.updateClock();
    }
}
