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

    public void showTasks(){
        for(Task task : taskManager.getTaskList()){
            System.out.println(taskManager.getCounter()+1 + ": " + task.getTask() + "\n");
            taskManager.setCounter(taskManager.getCounter()+1);
        }
        taskManager.setCounter(0);
    }

    public void run(){
        boolean isRunnable = true;
        while(isRunnable){
            taskView.showMenu();
            int number = taskView.getInt();
            taskView.clearBuffer();
            switch (number){
                case 1:
                    taskView.showString("Введите таск:");
                    taskManager.addTask(new Task(taskView.getString()));
                    break;
                case 2:
                    showTasks();
                    taskManager.removeTask(taskView.getInt());
                    break;
                case 3:
                    showTasks();
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
