package src;

import src.controller.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.run();
    }
}
