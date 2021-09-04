package program.windows.clock;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.util.Calendar;

/**
 *
 */
public class ClockView extends MasterView {
    static int lastMinuteValue;

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

    public boolean clockWasBehind() {
        Calendar cal = Calendar.getInstance();
        int currentMinute = cal.get(Calendar.MINUTE);
        if (currentMinute != lastMinuteValue) {
            updateClock();
            lastMinuteValue = currentMinute;
            return true;
        }
        else return false;
    }
}
