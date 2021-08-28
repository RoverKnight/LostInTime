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

    public static boolean shutdownWindowActive = false;

    public MasterController controller;

    // Fonts for use mostly in subclasses
    public Font ubuntuMonoB40 = new Font("Ubuntu Mono", Font.BOLD, 40);
    public Font ubuntuMonoB35 = new Font("Ubuntu Mono", Font.BOLD, 35);
    public Font ubuntuMonoB30 = new Font("Ubuntu Mono", Font.BOLD, 30);
    public Font ubuntuMonoB25 = new Font("Ubuntu Mono", Font.BOLD, 25);
    public Font ubuntuMonoB20 = new Font("Ubuntu Mono", Font.BOLD, 20);
    public Font ubuntuMonoB15 = new Font("Ubuntu Mono", Font.BOLD, 15);
    public Font ubuntuMonoB10 = new Font("Ubuntu Mono", Font.BOLD, 10);
    public Font ubuntuMonoI15 = new Font("Ubuntu Mono", Font.ITALIC, 15);

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
        JButton fileWriterWindowButton = new JButton("File Writer");
        JButton rngWindowButton = new JButton("RNG");
        JButton timerWindowButton = new JButton("Timer");
        JButton startWindowButton = new JButton("Clock");

        // groups some elements to simplify code
        JButton[] buttons = {
                shutdownButton, testWindowButton, topButton3,
                fileWriterWindowButton, rngWindowButton, timerWindowButton,
                startWindowButton
        };


        // sizes/positions GUI elements
        shutdownButton.setBounds(           600, oso, 100, 30);
        testWindowButton.setBounds(         500, oso, 100, 30);
        topButton3.setBounds(               400, oso, 100, 30);
        fileWriterWindowButton.setBounds(   300, oso, 100, 30);
        rngWindowButton.setBounds(          200, oso, 100, 30);
        timerWindowButton.setBounds(        100, oso, 100, 30);
        startWindowButton.setBounds(        0, oso, 100, 30);

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

    public static void setStandardBackground (Frame gui) {
        Color background = new Color(200, 200, 200);
        gui.setBackground(background);
    }


}