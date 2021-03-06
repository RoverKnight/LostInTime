package program.windows.randomNumberGenerator;


import program.exceptions.InvalidKeyException;
import program.exceptions.InvalidRangeException;

/**
 *
 */
public class RngInternal {

    public RngView gui;

    public static void generateRandomNumber (RngView gui) {
        int[] inputs;
        try {
            inputs = getInputs(gui);
        } catch (NumberFormatException ignored) {
            gui.setResult("Invalid input");
            return;
        } catch (InvalidRangeException ignored) {
            gui.setResult("Invalid range");
            return;
        } catch (InvalidKeyException ignored) {
            gui.setResult("Invalid key");
            return;
        }

        gui.setStatus("Generating...");

        RngGenerator random = new RngGenerator(gui, inputs[0], inputs[1], inputs[2]);
        random.start();
        while (random.isAlive()) {}
        String generatedNumber = String.valueOf(random.getGeneratedNumber());
        gui.setResult(generatedNumber);
    }

    public static int[] getInputs (RngView gui) throws NumberFormatException, InvalidRangeException, InvalidKeyException {
        int lowBound;
        int highBound;
        int key;
        long keyL; // uses long here to catch if user entered key w/ more than 6 digits, as detecting this fails
                   // if entered number has way too many digits
        keyL = Integer.parseInt(gui.keyInputField.getText());
        if (keyL > 999999) throw new InvalidKeyException();
        key = (int) keyL;

        lowBound = Integer.parseInt(gui.lowBoundInputField.getText());
        highBound = Integer.parseInt(gui.highBoundInputField.getText());
        if (lowBound >= highBound) throw new InvalidRangeException();

        return new int[] {lowBound, highBound, key};
    }

}
