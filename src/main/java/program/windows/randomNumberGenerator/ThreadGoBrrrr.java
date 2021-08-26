package program.windows.randomNumberGenerator;

public class ThreadGoBrrrr extends Thread {

    int lowBound;
    int highBound;
    int key;
    boolean shouldRun = true;

    public ThreadGoBrrrr (int lowBound, int highBound, int key) {
        this.lowBound = lowBound;
        this.highBound = highBound;
        this.key = key;
    }

    public void run () {
        int randomNumber = -1;

        long startTime = System.currentTimeMillis();

        while (shouldRun) {
            for (int i = lowBound; i <= highBound; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1); // cuz 7 is prime..?
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

        x.randomNumber = randomNumber;
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
