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

    // sets up infrastructure(?) vars
    TemplateListener listener;
    TemplateInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements (so they're accessible by listener)
    JLabel exampleLabel;
    JButton exampleButton;

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

        // creates GUI and makes the window visible
        createGUI();
        setVisible(true);

        // creates a controller (should be placed after createGUI() to
        // avoid errors)
        controller = new TemplateController(this);
        controller.start();

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    // GUI CREATOR
    // ============
    public void createGUI () {
        // creates gui elements, assigns to vars
        exampleLabel = new JLabel("00:00", SwingConstants.CENTER);
        exampleButton = new JButton("test");

        // groups some elements to simplify code
        JButton[] buttons = {
                exampleButton
        };

        // sizes/positions elements
        setBoundsByCC(exampleLabel, 350, 235, 400, 100);
        setBoundsByCC(exampleButton, 50, 100, 100, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        exampleLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 40));

        add(exampleLabel);
        add(exampleButton);

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
