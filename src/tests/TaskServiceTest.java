package src.tests;

import org.junit.Before;
import org.junit.Test;
import src.main.exceptions.DuplicateTaskException;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;
import src.main.service.TaskService;
import java.util.List;

import static org.junit.Assert.*;

public class TaskServiceTest {

    TaskService taskService;
    Task task;

    @Before
    public void setUp() throws DuplicateTaskException {
        taskService = new TaskService();
        task = new Task("Test task");
        taskService.addTask(task);
    }

    @Test
    public void addTask_shouldAddTask() throws DuplicateTaskException {
        Task task1 = new Task("Some other task");
        taskService.addTask(task1);
        assertTrue(taskService.getTaskList().contains(task1));
    }

    @Test(expected = DuplicateTaskException.class)
    public void addTask_shouldThrowDuplicateException() throws DuplicateTaskException {
        Task task2 = new Task("Test task");
        taskService.addTask(task2);
    }

    @Test
    public void removeTask_shouldRemoveTask() throws DuplicateTaskException {
        Task task2 = new Task("Test task 2");
        taskService.addTask(task2);
        assertTrue(taskService.getTaskList().contains(task2)); // убедились, что таск 2 был добавлен
        taskService.removeTask(task2);
        assertFalse(taskService.getTaskList().contains(task2));
    }

    @Test
    public void getList_shouldReturnList() throws DuplicateTaskException {
        taskService.addTask(new Task(2, "test", TaskPriority.HIGH));
        List<Task> list = taskService.getTaskList();
        assertNotNull(list);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), task);
        assertTrue(list.get(1).equals(new Task(2, "test", TaskPriority.HIGH)));
    }

    @Test
    public void getList_shouldReturnEmptyList() throws DuplicateTaskException {
        taskService.removeTask(task);
        assertTrue(taskService.getTaskList().isEmpty());
    }

}
