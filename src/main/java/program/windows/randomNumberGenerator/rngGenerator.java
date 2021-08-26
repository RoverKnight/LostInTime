package program.windows.randomNumberGenerator;

import program.MasterController;
import program.windows.clock.ClockView;

/**
 * Generates the random number. Is a subclass of MasterController(), though
 * is not named rngController, to make it clear that this class generates
 * the random number, not rngInternal(). This is also because this class
 * does not fulfill the typical role of a controller in the sense in which
 * that term is used within this project. The reason behind making
 * rngGenerator() a subclass of MasterController() is for convenience mostly.
 */
public class rngGenerator extends MasterController {

    rngView gui;

    public rngGenerator(rngView gui) {
        this.gui = gui;
    }

    public void run () {

    }
}
