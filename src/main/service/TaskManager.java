package src.main.service;

import src.main.model.Task;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void removeTask(int numberOfColumn) throws IndexOutOfBoundsException, InputMismatchException {
        taskList.remove(numberOfColumn - 1);
    }
}
