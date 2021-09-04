package program.windows.fileEditor;

import program.MasterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class FileEditorListener implements ActionListener, KeyListener {

    FileEditorView gui;

    public FileEditorListener(FileEditorView gui) {
        this.gui = gui;
        FileEditorInternal.gui = gui;
    }


    // updates content display every time a key is typed
    public void keyTyped (KeyEvent e) {
        FileEditorInternal.updateContentDisplay();
    }

    // just here because keyListener interface needs it
    public void keyPressed (KeyEvent e) {}
    public void keyReleased (KeyEvent e) {}


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

    }
}
