package program.windows.fileWriter;

import program.windows.test.TestInternal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 */
public class FileWriterListener implements ActionListener {

    FileWriterView gui;
    FileWriterInternal i;

    public FileWriterListener(FileWriterView gui, FileWriterInternal internal) {
        this.gui = gui;
        i = internal;
        i.gui = gui;
    }

    public void actionPerformed (ActionEvent e) {
        // gets event source
        Object source = e.getSource();

        // gets all text field inputs
        String inputField = gui.filePathTextField.getText();

        // source specific code
        if (source == gui.saveButton) {
            FileWriterInternal.save();
        }
        else if (source == gui.loadButton) {
            FileWriterInternal.load();
        }

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
