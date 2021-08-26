package program.windows.randomNumberGenerator;

import program.MasterController;

public class rngController extends MasterController {

    rngView gui;
    rngGenerator generator;

    public rngController (rngView gui, rngGenerator generator) {
        this.gui = gui;
        this.generator = generator;
    }

    public void run () {
        int numOfDots = 1;
        while (generator.isAlive()) {
            String text = "Generating";
            String dot = ".";
            for (int i = 0; i < numOfDots; i++) {
                text += dot;
            }
            System.out.println(text);
            gui.setStatus(text);
            if (numOfDots < 3) numOfDots++;
            else numOfDots = 1;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {}
        }
        gui.setStatus("Done");
    }

}
