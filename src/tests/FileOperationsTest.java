package src.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;
import src.main.service.FileOperations;
import src.main.service.TaskService;

import java.io.*;

public class FileOperationsTest {
    FileOperations fileOperations;
    TaskService taskService;
    Task task;

    @BeforeEach
    public void setUp(){
        taskService = new TaskService();
        task = new Task(1, "Test", TaskPriority.HIGH);
        taskService.addTask(task);
        fileOperations = new FileOperations(taskService);
    }
    @Test
    public void writeInFile_shouldThrowIOException() throws IOException {
        Assertions.assertThrows(IOException.class, () -> {
            fileOperations.writeInFile(taskService, "IOException.csv"); // file close for any change
        });
    }
    @Test
    public void writeInFile_shouldWriteInFile() throws IOException {
        // Стандартная запись в файл
        fileOperations.writeInFile(taskService, "writeInFileTest.csv");
        fileOperations.readFromFile("writeInFileTest.csv");
        for(Task task : taskService.getTaskList()){
            System.out.println(task.toString());
        }
        Assertions.assertTrue(taskService.getTaskList().contains(task));
    }
@Test
    public void readFromFile_shouldThrowFileNotFoundException(){
        Assertions.assertThrows(FileNotFoundException.class, ()->{
           fileOperations.readFromFile("unknown.csv");//Просто пустой файл
        });
    }
    @Test
    public void readFromFile_shouldReadFromFile() throws IOException {
        taskService = new TaskService();
        fileOperations = new FileOperations(taskService);
        taskService.addTask(task);
        fileOperations.writeInFile(taskService ,"writeInFileTest.csv");
        fileOperations.readFromFile("writeInFileTest.csv");
        Assertions.assertTrue(taskService.getTaskList().contains(task));
    }
}
