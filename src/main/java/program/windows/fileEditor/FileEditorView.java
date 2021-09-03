package program.windows.fileEditor;

import program.MasterView;
import program.styles.StyledButtonUI;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/**
 *
 */
public class FileEditorView extends MasterView {

    FileEditorListener listener;
    FileEditorInternal i;

    // sets up style vars
    ButtonUI buttonUI;

    // sets up vars for gui elements
    JButton saveButton;
    JButton loadButton;

    JTextField filePathTextField;
    JTextField fileNameTextField;
    JTextField fileSuffixTextField;

    JTextArea fileContentTextArea;
    JTextArea consoleFeedbackTextArea;

    public FileEditorView() {
        super("LostInTime - File Editor");

        // creates the listener instance
        listener = new FileEditorListener(this, i);

        // assigns styles to vars
        buttonUI = new StyledButtonUI();

        // sets general window settings (e.g. size, layout)
        setLayout(null);
        setCenteredFrameBounds(this, 700, 450);
        setStandardBackground(this);

        // self-explanatory
        createGUI();
        setVisible(true);

        // tells MasterView() that this is the active window
        activeWindow = this;
    }

    public void createGUI () {
        // creates gui elements, assigns to vars
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        filePathTextField = new JTextField("File Path");
        fileNameTextField = new JTextField("File Name");
        fileSuffixTextField = new JTextField("File Suffix (e.g. txt)");
        fileContentTextArea = new JTextArea("File Content");
        consoleFeedbackTextArea = new JTextArea("Console feedback");

        // groups some elements to simplify code
        JButton[] buttons = {
                saveButton, loadButton
        };
        JTextField[] textFields = {
                filePathTextField, fileNameTextField, fileSuffixTextField
        };
        JTextArea[]  textAreas = {
                fileContentTextArea, consoleFeedbackTextArea
        };

        // sizes/positions elements
        setBoundsByTL(filePathTextField,50, 25, 600, 25);
        setBoundsByTL(fileNameTextField,50, 75, 200, 25);
        setBoundsByTL(fileSuffixTextField,50, 125, 200, 25);
        setBoundsByTL(fileContentTextArea,275,75,375,275);
        setBoundsByTL(consoleFeedbackTextArea,50,375,600,50);

        setBoundsByBL(saveButton, 50, 350, 100, 50);
        setBoundsByBL(loadButton, 150, 350, 100, 50);

        // styles / adds listeners to / adds gui elements
        for (JButton button : buttons) {
            button.setUI(buttonUI);
            button.addActionListener(listener);
            add(button);
        }
        for (JTextField textField : textFields) {
            textField.setFont(ubuntuMonoI15);
            add(textField);
        }
        for (JTextArea textArea : textAreas) {
            textArea.setFont(ubuntuMonoI15);
            add(textArea);
        }

        // adds general GUI, updates GUI & makes window visible
        addGeneralGUI(this);
        setVisible(true);
    }

    public void writeToConsole (String text) { // console can hold 75 monospace chars per line
        //System.out.println("(Console)");
        consoleFeedbackTextArea.setText(FileEditorInternal.convertWithLineBreaks(text, 75));
    }

    public void writeToContent (String text) { // content box can hold 46 monospace chars per line
        //System.out.println("(File)");
        fileContentTextArea.setText(FileEditorInternal.convertWithLineBreaks(text, 45));
    }

    public String getContentWOutLineBreaks () {
        char[] characters = fileContentTextArea.getText().toCharArray();
        for (char character : characters) {
            if (character == 10) character = 32;
        }

        return new String(characters);
    }


}
