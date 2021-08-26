package program.windows.randomNumberGenerator;

import java.util.Scanner;

public class x {

    public static int randomNumber;

    public static void main (String[] args) {
        Scanner Input = new Scanner(System.in);

        System.out.println("Please enter your RNG range (integers only):");

        String rangeInput = "";

        while (rangeInput.equalsIgnoreCase("")) {

            System.out.println("Checking");
            rangeInput = Input.nextLine();

        }

        int[] bounds = new int[2];
        String[] inputBounds;

        inputBounds = rangeInput.split(" ");

        try {
            bounds[0] = Integer.parseInt(inputBounds[0]);
            bounds[1] = Integer.parseInt(inputBounds[1]);
        }
        catch (ArrayIndexOutOfBoundsException ignored) {
            System.out.println("Wrong input format (ArrayIndexOutOfBounds).");
            System.exit(0);
        }

        System.out.println("Please enter your RNG key (integers only, up to 6 digits):");

        String keyInput = "";

        while (keyInput.equalsIgnoreCase("")) {

            System.out.println("Checking");
            keyInput = Input.nextLine();

        }

        System.out.println("Key: "+keyInput);

        int key = Integer.parseInt(keyInput);

        generateRandomNumber(bounds[0], bounds[1], key);

        System.out.println("Your random number: "+randomNumber);
    }

    public static void generateRandomNumber (int lowBound, int highBound, int key) {
        ThreadGoBrrrr thread = new ThreadGoBrrrr(lowBound, highBound, key);
        thread.start();
        while (thread.isAlive()) {}
    }

















    public static void inputExample () {
        Scanner Input = new Scanner(System.in);

        String lul = "";

        while (lul.equalsIgnoreCase("")) {

            System.out.println("Checking");
            lul = Input.nextLine();

        }

        System.out.println(lul);
    }
}
