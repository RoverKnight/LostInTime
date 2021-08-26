package program;

import program.windows.clock.ClockInternal;
import program.windows.clock.ClockView;

public class Main {
    public static void main (String[] args) {
        // conforms operatingSystemOffset (oso) to OS
        String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")) MasterView.oso = 31;
        else if (operatingSystem.contains("Linux")) MasterView.oso = 24;
        else MasterView.oso = 100;

        // loads starting window
        ClockInternal i = new ClockInternal();
        new ClockView(i);
    }
}
