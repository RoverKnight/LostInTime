package program;

import program.windows.clock.ClockView;
import program.windows.fileEditor.FileEditorView;
import program.windows.randomNumberGenerator.RngView;
import program.windows.shutdownConfirm.ShutdownConfirmView;
import program.windows.gameOfLife.GameOfLifeView;
import program.windows.ticTacToe.TicTacToeView;
import program.windows.timer.TimerView;

/**
 *  MasterInternal() is more or less a code repository which is accessed
 *  by MasterListener() when needed.
 *  Note that MasterInternal() is NOT the superclass of the other internals,
 *  because the methods that it provides are/should be accessed ONLY
 *  by a MasterListener(), as only a MasterListener() is/should be ever
 *  assigned to the general GUI elements provided by MasterView.addGeneralGUI(),
 *  for which all methods in MasterInternal() are made. Therefore, making
 *  MasterInternal() the superclass of all other internals would have no use,
 *  as other internals won't find usages for any of the methods provided.
 */
public class MasterInternal {

    public MasterView gui;

    public MasterInternal () {

    }

    public static void loadWindow (String windowType) throws IllegalArgumentException {
        MasterView oldWindow = MasterView.activeWindow;
        if (windowType.equalsIgnoreCase("clock")) {
            new ClockView();
        }
        else if (windowType.equalsIgnoreCase("timer")) {
            new TimerView();
        }
        else if (windowType.equalsIgnoreCase("shutdownConfirmation")) {
            new ShutdownConfirmView();
            /*
            returning prevents current window from being set to invisible, so
            the shutdownConfirm window can be open whilst program can still function
             */
            return;
        }
        else if (windowType.equalsIgnoreCase("rng")) {
            new RngView();
        }
        else if (windowType.equalsIgnoreCase("game of life")) {
            new GameOfLifeView();
        }
        else if (windowType.equalsIgnoreCase("file editor")) {
            new FileEditorView();
        }
        else if (windowType.equalsIgnoreCase("tic tac toe")) {
            new TicTacToeView();
        }
        else throw new IllegalArgumentException("Window name wrong or not registered");

        oldWindow.setVisible(false);
        if (oldWindow.controller != null) oldWindow.controller.interrupt();
    }

    public static void shutdown () {
        System.exit(0);
    }
}
