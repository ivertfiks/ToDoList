package src.Controller;

import src.Model.Task;
import src.Service.TaskManager;
import src.View.TaskView;

import java.util.Scanner;

public class TaskController {

    TaskManager taskManager;
    TaskView taskView;

    public TaskController() {
        this.taskManager = new TaskManager();
        this.taskView = new TaskView();
    }

    public void run(){
        boolean isRunnable = true;
        while(isRunnable){
            taskView.showMenu();
            int number = taskView.getInt();
            taskView.clearBuffer();
            switch (number){
                case 1:
                    taskManager.addTask(new Task(taskView.getString()));
                    break;
                case 2:
                    taskManager.showTasks();
                    taskManager.removeTask(taskView.getInt());
                    break;
                case 3:
                    taskManager.showTasks();
                    break;
                case 4:
                    isRunnable = false;
                    break;
                default:
                    System.out.println();
                    break;
            }
        }
    }

}
