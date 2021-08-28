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

    public FileEditorView(FileEditorInternal internal) {
        super("LostInTime - File Writer");

        // assigns internal & gives it reference to this frame
        i = internal;
        i.gui = this;

        // creates the listener instance
        listener = new FileEditorListener(this, i);

        // assigns styles to vars
        buttonUI = new StyledButtonUI();

        // sets general window settings (e.g. size, layout)
        setLayout(null);
        setCenteredFrameBounds(this, 700, 500);
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
        setBoundsByTL(filePathTextField,50, 50, 600, 25);
        setBoundsByTL(fileNameTextField,50, 100, 200, 25);
        setBoundsByTL(fileSuffixTextField,50, 150, 200, 25);
        setBoundsByTL(fileContentTextArea,275,100,375,300);
        setBoundsByTL(consoleFeedbackTextArea,50,425,600,50);

        setBoundsByBL(saveButton, 50, 400, 100, 50);
        setBoundsByBL(loadButton, 150, 400, 100, 50);

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

    public void writeToConsole (String text) {
        consoleFeedbackTextArea.setText(text);
    }
}
