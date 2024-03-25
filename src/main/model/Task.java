package src.main.model;

import src.main.model.enum_model.TaskPriority;

import java.util.Objects;

public class Task {
    private String title;

    private static int idCounter = 0;
    private int id;
    private TaskPriority taskPriority;

    public Task(String task) {
        this.title = task;
        this.taskPriority = TaskPriority.LOW;
        idCounter++;
        id = idCounter;
    }

    public Task(int id, String title, TaskPriority taskPriority) {
        this.title = title;
        this.id = id;
        this.taskPriority = taskPriority;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return title;
    }

    public void setTask(String task) {
        this.title = task;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task otherTask = (Task) o;
        return (this.title.equalsIgnoreCase(otherTask.title));
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "id=" + id + '\'' +
                ", title='" + title +
                ", priority='" + taskPriority + '\'';
    }
}
