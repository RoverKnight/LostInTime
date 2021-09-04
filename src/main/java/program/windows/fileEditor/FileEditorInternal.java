package program.windows.fileEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class FileEditorInternal {

    public static FileEditorView gui;

    public static void test () {
        System.out.println("test");
    }

    public static String[] fetchInputs () {
        String fileName = gui.fileNameTextField.getText();
        String path = gui.filePathTextField.getText();
        String fileSuffix = gui.fileSuffixTextField.getText();

        if (!path.endsWith("/")) path += "/";
        if (!fileSuffix.startsWith(".") && !fileSuffix.isBlank()) fileSuffix = "." + fileSuffix;

        String fullPath = path + fileName + fileSuffix;

        return new String[]{fileName, fileSuffix, fullPath};
    }

    public static void save () {
        String[] inputs = fetchInputs();
        String fileName = inputs[0];
        String fileSuffix = inputs[1];
        String fullPath = inputs[2];

        // creates file var
        File file = new File(fullPath);

        // checks if file already exists (throws IOException if the provided directory
        // doesn't exist)
        boolean fileAlreadyExists;
        try {
            fileAlreadyExists = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            gui.writeToConsole(
                    "IO Exception occurred while fetching inputs. Please check if the " +
                    "entered directory exists and if the file suffix is valid."
            );
            return;
        }

        // writes to file
        try {
            FileWriter writer = new FileWriter(fullPath);
            writer.write(gui.fileContentTextArea.getText());
            writer.close();

            if (fileAlreadyExists) {
                gui.writeToConsole("Successfully created file "+fileName+fileSuffix+".");
            } else {
                gui.writeToConsole("Successfully edited " + fileName + fileSuffix);
            }
        } catch (IOException e) {
            gui.writeToConsole("IO Exception occurred while writing to file");
        }


    }

    public static void load () {
        // fetches inputs
        String[] inputs = fetchInputs();
        String fileName = inputs[0];
        String fileSuffix = inputs[1];
        String fullPath = inputs[2];

        // creates file var
        File file = new File(fullPath);

        //
        try {
            Scanner reader = new Scanner(file);
            String contentStr = "";
            while (reader.hasNextLine()) {
                contentStr += reader.nextLine() + System.lineSeparator();
            }
            gui.fileContentTextArea.setText(contentStr);
        } catch (FileNotFoundException e) {
            gui.writeToConsole(
                    "File could not be found. Check if the entered directory, file name and " +
                    "file suffix are correct."
            );
        }
    }

    public static void updateContentDisplay () {
        String currentText = gui.getContentWOutLineBreaks();
        gui.writeToContent(currentText);
    }

    public static String convertForDisplay (String text, int maxCharsPerLine) {
        char[] charArray = text.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }
        List<String> adjustedText = new ArrayList<>();

        int iterationCounter = 0; // used to prevent infinite looping (used in development)

        int length = charList.size();
        int ogLength = length;

        // adds line breaks
        while (length > maxCharsPerLine) {
            boolean foundBreak = false;
            while (!foundBreak) {
                for (int i = maxCharsPerLine; i >= 0; i--) {
                    //System.out.println(charList.size());
                    if (charList.get(i) == 32) {   // if character is a space
                        charList.set(i, (char) 10);      // replaces it with linefeed/-break

                        // gets the singular line & adds to final output
                        char[] lineChars = new char[i+1];
                        for (int x = 0; x < i+1; x++) {
                            lineChars[x] = charList.get(x);
                        }
                        adjustedText.add(new String(lineChars));

                        //System.out.println("ITERATION #: "+iterationCounter);

                        // deletes the just processed line from workload
                        for (int n = i; n >= 0; n--) {
                            charList.remove(0);
                            //System.out.println("This is trash man numero "+n);
                        }

                        // updates length (possible exit condition)
                        length = charList.size();

                        // sets exit condition
                        foundBreak = true;

                        break;
                    }
                    else if (charList.get(i) == 10) break; // this stops new linebreaks from being added
                                                           // every time load button is clicked
                }
                iterationCounter++;
                if (iterationCounter > charList.size()) break;
            }
            if (iterationCounter > charList.size()) break;
        }

        /*
        String nl = System.lineSeparator();
        System.out.println("Method was given:" +nl+
                "Length: "+ogLength+nl+
                "Text: "+text+nl+
                "Max chars per line: "+maxCharsPerLine
        );
        */

        // appends last line (since that is always missed by above loop)
        char[] lineChars = new char[charList.size()];
        for (int x = 0; x < charList.size(); x++) {
            lineChars[x] = charList.get(x);
        }
        adjustedText.add(new String(lineChars));

        // returns
        String output = "";
        for (int i = 0; i < adjustedText.size(); i++) {
            output += adjustedText.get(i);
        }
        return output;
    }

}
