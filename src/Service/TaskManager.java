package src.Service;

import src.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> taskList;
    private int counter = 0;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }


        public void addTask(Task task) {
            taskList.add(task);
        }

        public void showTasks(){
            for(Task task : taskList){
                System.out.println(counter + ": " + task.getTask() + "\n");
                counter++;
            }
            counter = 0;
        }

    public void removeTask(int numberOfColumn){
            taskList.remove(numberOfColumn);
        }
}
