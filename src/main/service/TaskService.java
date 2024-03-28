package src.main.service;

import src.main.exceptions.DuplicateTaskException;
import src.main.model.Task;
import src.main.exceptions.enum_exceptions.ExceptionMessage;
import src.main.model.enum_model.TaskStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private List<Task> taskList;
    private int counter = 0;

    public TaskService() {
        this.taskList = new ArrayList<>();
    }


    public void addTask(Task task) {
        try {
            if (taskList.contains(task))
                throw new DuplicateTaskException(ExceptionMessage.DUPLICATE_TASK_EXCEPTION.getCommandName());
            taskList.add(task);
        } catch (DuplicateTaskException e) {
                e.getMessage();
            }
        }
        public void setStatus(int id, String status) throws IOException {
            for (Task task : taskList) {
                if (task.getId() == id) {
                    task.setTaskStatus(TaskStatus.valueOf(status.toUpperCase()));
                }
            }
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

    public void removeTask(Task task){
        int id = task.getId();
        taskList.remove(task);
        for(Task tasktemp : taskList){
            if(tasktemp.getId() > id){
                tasktemp.setId(tasktemp.getId()-1);
            }
        }
    }
}
