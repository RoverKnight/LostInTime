package program.windows.fileWriter;

import program.windows.test.TestView;

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
public class FileWriterInternal {

    public static FileWriterView gui;

    public static void test () {

    }

    public static void save () {
        // fetches inputs
        String fileName = gui.fileNameTextField.getText();
        String path = gui.filePathTextField.getText();
        if (!path.endsWith("/")) path += "/";
        String fileSuffix = gui.fileSuffixTextField.getText();
        if (!fileSuffix.startsWith(".") && !fileSuffix.isBlank()) fileSuffix = "." + fileSuffix;
        String fullPath = path + fileName + fileSuffix;

        // creates file var
        File file = new File(fullPath);

        // checks if file already exists (throws IOException if the provided directory
        // doesn't exist)
        try {
            boolean fileAlreadyExists = file.createNewFile();
            if (fileAlreadyExists) {
                gui.writeToConsole("File created.");
            } else {
                gui.writeToConsole("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            gui.writeToConsole(
                    "IO Exception occurred while fetching inputs. Please check if the" +
                    "entered directory exists and if the given file suffix is valid."
            );
            return;
        }

        // writes to file
        try {
            FileWriter writer = new FileWriter(fullPath);
            writer.write(gui.fileContentTextArea.getText());
            writer.close();
            gui.writeToConsole("Successfully edited " + fileName + fileSuffix);
        } catch (IOException e) {
            e.printStackTrace();
            gui.writeToConsole("IO Exception occurred while writing to file");
        }


    }

    public static void load () {
        // fetches inputs
        String fileName = gui.fileNameTextField.getText();
        String path = gui.filePathTextField.getText();
        if (!path.endsWith("/")) path += "/";
        String fileSuffix = gui.fileSuffixTextField.getText();
        if (!fileSuffix.startsWith(".") && !fileSuffix.isBlank()) fileSuffix = "." + fileSuffix;
        String fullPath = path + fileName + fileSuffix;
        // creates file var
        File file = new File(fullPath);

        //
        try {
            Scanner reader = new Scanner(file);
            List<String> contentList = new ArrayList<>();
            String contentStr = "";
            while (reader.hasNextLine()) {
                //contentList.add(reader.nextLine());
                contentStr += reader.nextLine() + System.lineSeparator();
            }
            gui.fileContentTextArea.setText(contentStr);
            System.out.println(contentStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            gui.writeToConsole(
                    "File could not be found. Check if the entered directory, file name and" +
                    "file suffix are correct."
            );
        }
    }

}
