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
     *  oso is short for operatingSystemOffset & is used to adjust vertical positioning for
     *  different OS, as the window's top bar counts as part of the window and this
     *  offset is needed to properly position the GUI
     */
    public static int oso;

    /**
     *  tbo is short for topBarOffset & is used to adjust the height of
     *  the top bar given by MasterView.addGeneralGUI() and lets
     *  window-views position gui elements relative to the bottom line
     *  of the given top bar
     */
    private static final int tbo = 30;

    /**
     *  co is short for combinedOffset & combines oso & tbo
     */
    private static int co;

    protected int usableHeight;

    protected static ButtonUI standardButtonUI = new StyledButtonUI();
    protected ButtonUI customButtonUI;

    public static boolean shutdownWindowActive = false;

    public MasterController controller;

    // Fonts for use mostly in subclasses
    protected static Font ubuntuMonoB40 = new Font("Ubuntu Mono", Font.BOLD, 40);
    protected static Font ubuntuMonoB35 = new Font("Ubuntu Mono", Font.BOLD, 35);
    protected static Font ubuntuMonoB30 = new Font("Ubuntu Mono", Font.BOLD, 30);
    protected static Font ubuntuMonoB25 = new Font("Ubuntu Mono", Font.BOLD, 25);
    protected static Font ubuntuMonoB20 = new Font("Ubuntu Mono", Font.BOLD, 20);
    protected static Font ubuntuMonoB15 = new Font("Ubuntu Mono", Font.BOLD, 15);
    protected static Font ubuntuMonoB10 = new Font("Ubuntu Mono", Font.BOLD, 10);
    protected static Font ubuntuMonoI15 = new Font("Ubuntu Mono", Font.ITALIC, 15);

    public static MasterView activeWindow;

    public MasterView (String windowName) {
        super(windowName);
    }

    protected int getUsableHeight () {
        return getHeight() - co;
    }

    public static void updateCombinedOffset() {
        co = tbo + oso;
    }

    protected static void addGeneralGUI (MasterView gui) {

        // sets up reference variables
        MasterListener listener = new MasterListener(gui);

        // creates GUI elements
        JButton shutdownButton = new JButton("Shut down");
        JButton gameOfLifeButton = new JButton("Game of Life");
        JButton ticTacToeButton = new JButton("Tic Tac Toe");
        JButton fileWriterWindowButton = new JButton("File Editor");
        JButton rngWindowButton = new JButton("RNG");
        JButton timerWindowButton = new JButton("Timer");
        JButton startWindowButton = new JButton("Clock");

        // groups some elements to simplify code
        JButton[] buttons = {
                shutdownButton, gameOfLifeButton, ticTacToeButton,
                fileWriterWindowButton, rngWindowButton, timerWindowButton,
                startWindowButton
        };


        // sizes/positions GUI elements
        shutdownButton.setBounds(           600, oso, 100, tbo);
        gameOfLifeButton.setBounds(         500, oso, 100, tbo);
        ticTacToeButton.setBounds(          400, oso, 100, tbo);
        fileWriterWindowButton.setBounds(   300, oso, 100, tbo);
        rngWindowButton.setBounds(          200, oso, 100, tbo);
        timerWindowButton.setBounds(        100, oso, 100, tbo);
        startWindowButton.setBounds(        0, oso, 100, tbo);

        for (JButton button : buttons) {
            button.addActionListener(listener);
            button.setUI(standardButtonUI);
            gui.add(button);
        }
    }

    protected static void setBoundsByTL (JComponent element, int left__X, int top___Y, int width, int height) {
        // left__X is already fine
        int y = top___Y + co;
        element.setBounds(left__X, y, width, height);
    }

    protected static void setBoundsByTC (JComponent element, int centerX, int top___Y, int width, int height) {
        int x = centerX - width/2;
        int y = top___Y + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setBoundsByTR (JComponent element, int right_X, int top___Y, int width, int height) {
        int x = right_X - width;
        int y = top___Y + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setBoundsByCL (JComponent element, int left__X, int centerY, int width, int height) {
        // left__X is already fine
        int y = centerY - height/2 + co;
        element.setBounds(left__X, y, width, height);
    }

    protected static void setBoundsByCC (JComponent element, int centerX, int centerY, int width, int height) {
        int x = centerX - width/2;
        int y = centerY - height/2 + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setBoundsByCR (JComponent element, int right_X, int centerY, int width, int height) {
        int x = right_X - width;
        int y = centerY - height/2 + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setBoundsByBL (JComponent element, int left__X, int bottomY, int width, int height) {
        // left__X is already fine
        int y = bottomY - height + co;
        element.setBounds(left__X, y, width, height);
    }

    protected static void setBoundsByBC (JComponent element, int centerX, int bottomY, int width, int height) {
        int x = centerX - width/2;
        int y = bottomY - height + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setBoundsByBR (JComponent element, int right_X, int bottomY, int width, int height) {
        int x = right_X - width;
        int y = bottomY - height + co;
        element.setBounds(x, y, width, height);
    }

    protected static void setCenteredFrameBounds (Frame gui, int width, int heightForOwnGUI) {
        // java - get screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int x = screenWidth/2 - width/2;
        int y = screenHeight/2 - heightForOwnGUI/2;

        int height = heightForOwnGUI + co;

        gui.setBounds(x, y, width, height);
    }

    protected static void setStandardBackground (Frame gui) {
        Color background = new Color(200, 200, 200);
        gui.setBackground(background);
    }


}