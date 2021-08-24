package program.windows.template;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

/**
 *
 */
public class TemplateView extends MasterView {

    // SETUP
    // =====

    TemplateListener listener;
    TemplateInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JLabel clockLabel;
    JButton testButton;

    // CONSTRUCTOR
    // ===========
    public TemplateView(TemplateInternal internal) {

        super("LostInTime - Clock");

        // assigns internal & gives it reference to this frame
        i = internal;
        i.gui = this;

        // creates the listener instance
        listener = new TemplateListener(this, i);

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
        controller = new TemplateController(this);
        controller.start();

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    // GUI CREATOR
    // ============
    public void createGUI () {
        // creates gui elements, assigns to vars
        clockLabel = new JLabel("00:00", SwingConstants.CENTER);
        testButton = new JButton("test");

        // groups some elements to simplify code
        JButton[] buttons = {
            testButton
        };

        // sizes/positions elements
        setBoundsByCC(clockLabel, 350, 235, 400, 100);
        setBoundsByCC(testButton, 50, 100, 100, 50);

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

    // GUI UPDATER(s)
    // ==============
    public void updateGUI () {
        updateResponsiveGUI();
        updateTimedGUI();
    }

    public void updateResponsiveGUI () {

    }

    public void updateTimedGUI () {

    }
}
