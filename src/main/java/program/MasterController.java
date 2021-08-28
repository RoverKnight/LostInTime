package program;

import java.awt.*;

/**
 * MasterController() is the subclass for all window-specific threads.
 * A Controller shall be used if there are any actions available to
 * the user on a given window that require time control/management
 * (e.g. a timer) or need to be continuously updated (e.g. a clock).
 */
public class MasterController extends Thread {

    public boolean isPaused;
}
