package program.windows.fileWriter;

import program.MasterController;
import program.windows.test.TestView;

public class FileWriterController extends MasterController {

    FileWriterView gui;

    public FileWriterController(FileWriterView gui) {
        this.gui = gui;
    }

    public void run () {
        System.out.println("Yahtzee");
    }
}
