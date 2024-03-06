package src.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.model.Task;

public class ModelTaskTest {

    Task task;

    @BeforeEach
    public void setUp(){
        task = new Task("Test task...");
    }

    @Test
    public void testGetTask(){
        String result = "Test task...";
        Assertions.assertEquals("Test task...", result,task.getTask());
    }

    @Test
    public void testSetTask(){
        String result = "Rewrite task text...";
        task.setTask(result);
        Assertions.assertEquals("Rewrite task text...", task.getTask());
    }

}
