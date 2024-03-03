package src.controller;

import src.model.Task;
import src.service.TaskManager;
import src.view.TaskView;

import java.util.InputMismatchException;

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
                    taskView.showString("Enter task:");
                    taskManager.addTask(new Task(taskView.getString()));
                    break;
                case 2:
                    showTasks();
                    try {
                        taskManager.removeTask(taskView.getInt());
                    }catch (InputMismatchException | IndexOutOfBoundsException exception){
                        taskView.clearBuffer();
                        if (exception instanceof InputMismatchException){
                            taskView.showString("You input wrong symbol...");
                        }else if(exception instanceof IndexOutOfBoundsException){
                            taskView.showString(exception.getMessage());
                        }else{
                            taskView.showString("Unexpected error");
                        }
                    }
                    break;
                case 3:
                    showTasks();
                    break;
                case 4:
                    isRunnable = false;
                    break;
                default:
                    taskView.showString("Wrong menu number...\n");
                    break;
            }
        }
    }

}
