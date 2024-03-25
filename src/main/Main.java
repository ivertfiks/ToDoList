package src.main;

import src.main.config.RunMode;
import src.main.controller.TaskController;
import src.main.exceptions.DuplicateTaskException;

public class Main {
    public static void main(String[] args) throws DuplicateTaskException {
        TaskController taskController = new TaskController();
        RunMode runMode = RunMode.CONSOLE;
        taskController.setRunMode(runMode);
        taskController.run();
    }
}
