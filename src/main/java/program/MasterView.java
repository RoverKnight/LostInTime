package program;

import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

/**
 *  MasterView() is the superclass of all other views. It provides them
 *  with useful methods for positioning their own GUI elements, adding
 *  the general GUI (top bar), setting the standard background color,
 *  and more.
 */
public class MasterView extends Frame {

    /**
     *  oso is short for operatingSystemOffset & adjusts vertical positioning for
     *  different OS, as the window's top bar counts as part of the window and this
     *  offset is needed to properly position the GUI
     */
    public static int oso;

    public MasterController controller;

    public static MasterView activeWindow;

    public MasterView (String windowName) {
        super(windowName);
    }

    public static void addGeneralGUI (MasterView gui) {

        // sets up reference variables
        MasterListener listener = new MasterListener(gui);
        ButtonUI buttonUI = new StyledButtonUI();

        // creates GUI elements
        JButton shutdownButton = new JButton("Shut down");
        JButton testWindowButton = new JButton("Test");
        JButton topButton3 = new JButton("3");
        JButton topButton4 = new JButton("4");
        JButton topButton5 = new JButton("5");
        JButton timerWindowButton = new JButton("Timer");
        JButton startWindowButton = new JButton("Clock");

        // groups some elements to simplify code
        JButton[] buttons = {
                shutdownButton, testWindowButton, topButton3,
                topButton4, topButton5, timerWindowButton,
                startWindowButton
        };


        // sizes/positions GUI elements
        shutdownButton.setBounds(   600, oso, 100, 30);
        testWindowButton.setBounds(       500, oso, 100, 30);
        topButton3.setBounds(       400, oso, 100, 30);
        topButton4.setBounds(       300, oso, 100, 30);
        topButton5.setBounds(       200, oso, 100, 30);
        timerWindowButton.setBounds( 100, oso, 100, 30);
        startWindowButton.setBounds(0, oso, 100, 30);

        for (JButton button : buttons) {
            button.addActionListener(listener);
            button.setUI(buttonUI);
            gui.add(button);
        }
    }

    public static void setBoundsByTL (JComponent element, int left__X, int top___Y, int width, int height) {
        // left__X is already fine
        int y = top___Y + oso;
        element.setBounds(left__X, y, width, height);
    }

    public static void setBoundsByTC (JComponent element, int centerX, int top___Y, int width, int height) {
        int x = centerX - width/2;
        int y = top___Y + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setBoundsByTR (JComponent element, int right_X, int top___Y, int width, int height) {
        int x = right_X - width;
        int y = top___Y + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setBoundsByCL (JComponent element, int left__X, int centerY, int width, int height) {
        // left__X is already fine
        int y = centerY - height/2 + oso;
        element.setBounds(left__X, y, width, height);
    }

    public static void setBoundsByCC (JComponent element, int centerX, int centerY, int width, int height) {
        int x = centerX - width/2;
        int y = centerY - height/2 + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setBoundsByCR (JComponent element, int right_X, int centerY, int width, int height) {
        int x = right_X - width;
        int y = centerY - height/2 + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setBoundsByBL (JComponent element, int left__X, int bottomY, int width, int height) {
        // left__X is already fine
        int y = bottomY - height + oso;
        element.setBounds(left__X, y, width, height);
    }

    public static void setBoundsByBC (JComponent element, int centerX, int bottomY, int width, int height) {
        int x = centerX - width/2;
        int y = bottomY - height + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setBoundsByBR (JComponent element, int right_X, int bottomY, int width, int height) {
        int x = right_X - width;
        int y = bottomY - height + oso;
        element.setBounds(x, y, width, height);
    }

    public static void setCenteredFrameBounds (Frame gui, int width, int heightWOutOSO) {
        // java - get screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int x = screenWidth/2 - width/2;
        int y = screenHeight/2 - heightWOutOSO/2;

        int height = heightWOutOSO + oso;

        gui.setBounds(x, y, width, height);
    }

    @Deprecated // just can't make it work... should make center of new window same as center of previous window
    public static void setAdjustedFrameBounds (Frame gui, int width, int heightWOutOSO) {

        // NOTE: this method currently does not work as intended because the x/y coordinates of the previous
        // window are not updated as it is moved around

        System.out.println(activeWindow);

        int previousWindowWidth = activeWindow.getWidth();
        int previousWindowHeight = activeWindow.getHeight();
        int previousWindowX = activeWindow.getX();
        int previousWindowY = activeWindow.getY();

        int x = previousWindowX + previousWindowWidth/2 - width/2;
        int y = previousWindowY + previousWindowHeight/2 - heightWOutOSO/2;
        int height = heightWOutOSO + oso;

        System.out.println(previousWindowX);
        System.out.println(previousWindowY);
        System.out.println(x);
        System.out.println(y);

        gui.setBounds(x, y, width, height);
    }

    public static void setStandardBackground (Frame gui) {
        Color background = new Color(200, 200, 200);
        gui.setBackground(background);
    }


}