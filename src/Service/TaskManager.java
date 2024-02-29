package src.Service;

import src.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> taskList;
    private int counter;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

        public List<Task> getTaskList() {
            return taskList;
        }

        public void addTask(Task task) {
            taskList.add(task);
        }
}
