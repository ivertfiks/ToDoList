package src.main;

import src.main.controller.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.run();
    }
}
