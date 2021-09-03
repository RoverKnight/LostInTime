package program.windows.gameOfLife;

import program.MasterController;

/**
 * Thread class - for testing & copy/pasting purposes
 */
public class GameOfLifeController extends MasterController {

    GameOfLifeView gui;

    public GameOfLifeController(GameOfLifeView gui) {
        this.gui = gui;
    }

    public void run () {
        System.out.println("Yahtzee");
    }
}
