package program.windows.clock;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 *
 */
public class ClockView extends MasterView {

    // sets up vars for gui elements
    JLabel clockLabel;

    public ClockView () {
        super("LostInTime - Clock");

        // gives internal reference to this frame
        ClockInternal.gui = this;

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

        // groups some elements to simplify code
        JLabel[] labels = {
                clockLabel
        };

        // sizes/positions elements
        int midY = usableHeight / 2;

        setBoundsByCC(clockLabel, 350, midY-15, 400, 100);

        // styles / adds gui elements
        for (JLabel label : labels) {
            label.setFont(ubuntuMonoB40);
            add(label);
        }

        // adds general GUI, updates GUI & makes window visible
        addGeneralGUI(this);
        updateGUI();
        setVisible(true);
    }

    public void updateGUI () {
        ClockInternal.updateClock();
    }
}
