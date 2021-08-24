package program.windows.timer;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

/**
 *
 */
public class TimerView extends MasterView {

    // sets up reference vars for listener/internal
    TimerListener listener;
    TimerInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel timerLabel;
    JButton testButton;
    JButton startButton;
    JButton stopButton;
    JButton resetButton;
    JButton addToRecordButton;
    JButton lapButton;
    JButton resumeButton;


    public TimerView(TimerInternal internal) {
        super("LostInTime - Timer");

        // assigns internal & gives it reference to this frame
        i = internal;
        i.gui = this;

        // creates the listener instance
        listener = new TimerListener(this, i);

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
        timerLabel = new JLabel("00:00.00", SwingConstants.CENTER);
        testButton = new JButton("Test");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        addToRecordButton = new JButton("Add to record");
        lapButton = new JButton("Lap");
        resumeButton = new JButton("Resume");

        // groups some elements to simplify code
        JButton[] buttons = {
                testButton, startButton, stopButton,
                resetButton, addToRecordButton, lapButton,
                resumeButton
        };

        // sizes/positions elements
        setBoundsByCC(timerLabel, 350, 235, 400, 100);
        setBoundsByBL(testButton, 0, 500, 100, 50);
        setBoundsByTR(startButton, 350, 275, 100, 50);
        setBoundsByTL(stopButton, 350, 275, 100, 50);
        setBoundsByTR(resetButton, 350, 275, 100, 50);
        setBoundsByTL(resumeButton, 350, 275, 100, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        timerLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 40));
        add(timerLabel);

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
        autoSwitchStartResetButtons();
        autoSwitchStopResumeButtons();
    }

    public void updateTimedGUI () {

    }

    public void autoSwitchStartResetButtons() {

        // if timer is running or has run
        if ((controller != null && controller.isAlive()) || !timerLabel.getText().equalsIgnoreCase("00:00.00")) {
            startButton.setVisible(false);
            resetButton.setVisible(true);
        }
        // if timer hasn't run yet
        else {
            resetButton.setVisible(false);
            startButton.setVisible(true);

        }
    }

    public void autoSwitchStopResumeButtons() {

        // if timer is running
        if (controller != null && controller.isAlive()) {
            if (!stopButton.isVisible()) stopButton.setVisible(true);
            if (resumeButton.isVisible()) resumeButton.setVisible(false);
        }
        // if timer was stopped
        else if (!timerLabel.getText().equalsIgnoreCase("00:00.00")) {
            if (stopButton.isVisible()) stopButton.setVisible(false);
            if (!resumeButton.isVisible()) resumeButton.setVisible(true);
        }
        // if timer hasn't run yet or has been reset
        else {
            if (stopButton.isVisible()) stopButton.setVisible(false);
            if (resumeButton.isVisible()) resumeButton.setVisible(false);
        }
    }


}
