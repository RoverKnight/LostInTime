package program.windows.randomNumberGenerator;

import program.MasterController;

/**
 * Generates the random number. Is a subclass of MasterController(), though
 * is not named RngController, to make it clear that this class generates
 * the random number, not RngInternal(). This is also because this class
 * does not fulfill the typical role of a controller in the sense in which
 * that term is used within this project. The reason behind making
 * RngGenerator() a subclass of MasterController() is for convenience mostly.
 */
public class RngGenerator extends MasterController {

    RngView gui;
    int lowBound;
    int highBound;
    int key;
    boolean shouldRun = true;
    public int randomNumber = -1;

    public RngGenerator(RngView gui, int lowBound, int highBound, int key) {
        this.gui = gui;
        this.lowBound = lowBound;
        this.highBound = highBound;
        this.key = key;
    }

    public void run () {

        RngController loadingAnimator = new RngController(gui, this);
        loadingAnimator.setPriority(1);
        this.setPriority(2);
        loadingAnimator.start();

        long startTime = System.currentTimeMillis();

        while (shouldRun) {
            for (int i = lowBound; i <= highBound; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(7);
                    randomNumber = i;
                } catch (InterruptedException ignored) {
                    System.out.println("Fuck");
                }
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;
                if (elapsedTime >= getCrossSum(key) * 100)
                {
                    shouldRun = false;
                    break;
                }
            }
        }
    }

    public int getGeneratedNumber () {
        return randomNumber;
    }

    public static long getCrossSum (int number) {

        int[] digits = getDigits(number);
        long crossSum = 0;

        for (int i = 0; i < digits.length; i++) {
            crossSum += digits[i];
        }

        return crossSum;
    }

    public static int[] getDigits (int number) {
        String numStr = String.valueOf(number);
        String[] digitsStr = numStr.split("");

        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Integer.parseInt(digitsStr[i]);
        }

        return digits;
    }
}
