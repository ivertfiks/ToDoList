package src.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.exceptions.DuplicateTaskException;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;
import src.main.service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceTest {

    TaskService taskService;
    Task task;

    @BeforeEach
    public void setUp(){
        taskService = new TaskService();
        task = new Task("Test task");
    }
    @Test
    public void addTask_shouldAddTask(){
        taskService.addTask(task);
        Assertions.assertTrue(taskService.getTaskList().contains(task));
    }
    @Test
    public void addTask_shouldThrowDuplicateException(){
            DuplicateTaskException duplicateTaskExceptionThrown = Assertions.assertThrows(DuplicateTaskException.class, () ->{
           taskService.addTask(task);
           taskService.addTask(task); // error
        });

    }
    @Test
    public void removeTask_shouldRemoveTask(){
        taskService.addTask(task);
        taskService.removeTask(task);
        Assertions.assertTrue(taskService.getTaskList().isEmpty());
    }
    @Test
    public void getList_shouldReturnList(){
        taskService.addTask(task);
        taskService.addTask(new Task(2,"test", TaskPriority.HIGH));
        List<Task> list = new ArrayList<>();
        list.add(task);
        list.add(new Task(2,"test", TaskPriority.HIGH));
        Assertions.assertEquals(taskService.getTaskList(), list);
    }
    @Test
    public void getList_shouldReturnEmptyList(){
        taskService.addTask(task);
        taskService.removeTask(task);
        Assertions.assertTrue(taskService.getTaskList().isEmpty());
    }

}
