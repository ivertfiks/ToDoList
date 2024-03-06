package src.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.model.Task;
import src.main.service.TaskManager;
import src.main.view.TaskView;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerTest {
    private TaskManager taskManager;

    @BeforeAll
    public static void setUpAll(){
        TaskView taskView = new TaskView();
    }
    @BeforeEach
    public void setUp(){
        taskManager = new TaskManager();
    }

    @Test
    public void addTaskTest(){
        String taskDescription = "Hello";
        taskManager.addTask(new Task(taskDescription));
        Assertions.assertTrue(taskManager.getTaskList().getFirst().getTask().contains(taskDescription));
    }

    @Test
    public void removeTaskTest(){
            String taskDescription = "Hello";
            taskManager.addTask(new Task(taskDescription));
            taskManager.removeTask(1);
            Assertions.assertTrue(taskManager.getTaskList().isEmpty());
    }

    @Test
    public void removeTaskInputMismatchExceptionTest(){
        String test = "test";
        Scanner sc = new Scanner(new ByteArrayInputStream(test.getBytes()));
        Assertions.assertThrows(InputMismatchException.class, () -> {
            taskManager.removeTask(sc.nextByte());
        });
    }

    @Test
    public void removeTaskIndexOutOfBoundsExceptionTest(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
           taskManager.removeTask(12);
        });
    }
}
