package program.windows.randomNumberGenerator;

import program.MasterView;
import program.styles.StyledButtonUI;
import program.windows.clock.ClockController;
import program.windows.clock.ClockInternal;
import program.windows.clock.ClockListener;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.util.Calendar;

/**
 *
 */
public class rngView extends MasterView {

    rngListener listener;
    rngInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel clockLabel;
    JButton testButton;

    public rngView(rngInternal internal) {
        super("LostInTime - Clock");

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

        // creates a clock updater & starts it (must be after createGUI()!)
        controller = new rngGenerator(this);
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
        setBoundsByCC(clockLabel, 350, 235, 400, 100);
        setBoundsByBL(testButton, 0, 500, 100, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        clockLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 40));

        add(clockLabel);
        add(testButton);

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
        updateClock();
    }

    public void updateClock () {
        Calendar cal = Calendar.getInstance();
        String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(cal.get(Calendar.MINUTE));
        String zero = "0";

        if (hour.length() == 1) hour = zero + hour;
        if (minute.length() == 1) minute = zero + minute;

        String time = hour + ":" + minute;
        clockLabel.setText(time);
    }
}
