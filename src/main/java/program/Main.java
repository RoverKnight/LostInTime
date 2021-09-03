package program;

import program.windows.clock.ClockView;

public class Main {
    public static void main (String[] args) {
        // conforms operatingSystemOffset (oso) to OS
        String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")) MasterView.oso = 31;
        else if (operatingSystem.contains("Linux")) MasterView.oso = 24;
        else MasterView.oso = 100;

        // updates combinedOffset (since oso was just changed)
        MasterView.updateCombinedOffset();

        // loads starting window
        new ClockView();
    }
}
