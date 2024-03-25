package src.tests;
import src.main.exceptions.DuplicateTaskException;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;
import src.main.service.FileOperations;
import src.main.service.TaskService;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class FileOperationsTest {
    FileOperations fileOperations;
    TaskService taskService;
    Task task;

    @Before
    public void setUp() throws DuplicateTaskException {
        taskService = new TaskService();
        task = new Task(1, "Test", TaskPriority.HIGH);
        taskService.addTask(task);
        fileOperations = new FileOperations(taskService);
    }
    @Test
    public void writeInFile_shouldThrowIOException() throws IOException {
        assertThrows(IOException.class, () -> {
            fileOperations.writeInFile(taskService, "IOException.csv"); // file close for any change
        });
    }
    @Test
    public void writeInFile_shouldWriteInFile() throws IOException, DuplicateTaskException {
        // Стандартная запись в файл
        fileOperations.writeInFile(taskService, "writeInFileTest.csv");
        fileOperations.readFromFile("writeInFileTest.csv");
        for(Task task : taskService.getTaskList()){
            System.out.println(task.toString());
        }
        assertTrue(taskService.getTaskList().contains(task));
    }
    @Test
    public void readFromFile_shouldThrowFileNotFoundException(){
        assertThrows(FileNotFoundException.class, ()->{
            fileOperations.readFromFile("unknown.csv");//Просто пустой файл
        });
    }
    @Test
    public void readFromFile_shouldReadFromFile() throws IOException, DuplicateTaskException {
        taskService = new TaskService();
        fileOperations = new FileOperations(taskService);
        taskService.addTask(task);
        fileOperations.writeInFile(taskService ,"writeInFileTest.csv");
        fileOperations.readFromFile("writeInFileTest.csv");
        assertTrue(taskService.getTaskList().contains(task));
    }
}
