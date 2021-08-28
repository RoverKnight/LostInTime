package program.windows.fileEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class FileEditorListener implements ActionListener {

    FileEditorView gui;
    FileEditorInternal i;

    public FileEditorListener(FileEditorView gui, FileEditorInternal internal) {
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
            FileEditorInternal.save();
        }
        else if (source == gui.loadButton) {
            FileEditorInternal.load();
        }

        // updates GUI (important!!!)
        gui.updateGUI();
    }
}
