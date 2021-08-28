package program.windows.test;

import program.MasterController;
import program.windows.clock.ClockView;

public class TestController extends MasterController {

    TestView gui;

    public TestController(TestView gui) {
        this.gui = gui;
    }

    public void run () {
        System.out.println("Yahtzee");
    }
}
