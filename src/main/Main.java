package src.main;

import src.main.config.RunMode;
import src.main.controller.TaskController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        RunMode runMode = RunMode.FILE_PARSING;
        taskController.setRunMode(runMode);
        try {
            taskController.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
