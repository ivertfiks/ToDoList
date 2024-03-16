package src.main;

import src.main.config.RunMode;
import src.main.controller.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        RunMode runMode = RunMode.CONSOLE;
        taskController.setRunMode(runMode);
        taskController.run();
    }
}
