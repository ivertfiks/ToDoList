package src.tests;


import org.junit.Before;
import src.main.service.FileOperations;
import src.main.service.TaskService;

public class FileOperationsTest {
    FileOperations fileOperations;
    TaskService taskService;
    @Before
    public void setUp(){
        fileOperations = new FileOperations(taskService);
        taskService = new TaskService();
    }

    public void stringToTasks_shouldThrowIllegalArgumentException(){

    }

    public void stringToTasks_shouldReturnTaskList(){

    }

    public void writeInFile_shouldWriteInFile(){

    }

    public void writeInFile_shouldThrowIOException(){

    }

    public void readFromFile_shouldReadFromFile(){

    }

    public void readFromFile_shouldThrowFileNotFoundException(){

    }

    public void readFromFile_shouldThrowRuntimeException(){

    }
}
