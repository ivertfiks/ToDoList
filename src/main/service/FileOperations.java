package src.main.service;

import src.main.exceptions.DuplicateTaskException;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    TaskService taskService;

    public FileOperations(TaskService taskService) {
        this.taskService = taskService;
    }

    public void writeInFile(TaskService taskService, String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id;").append("name;").append("taskPriority").append("\n");
        File csvFile = new File(path);
        try (FileWriter fileWriter = new FileWriter(csvFile)) {
            for (Task task : taskService.getTaskList()) {
                stringBuilder.append(task.getId());
                stringBuilder.append(";");
                stringBuilder.append(task.getTask());
                stringBuilder.append(";");
                stringBuilder.append(task.getTaskPriority());
                stringBuilder.append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void readFromFile(String path) throws FileNotFoundException, DuplicateTaskException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            taskService = new TaskService();
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] taskStringParts = line.split(";"); // [1][Develop Feature A][HIGH]
                Task task = stringToTask(taskStringParts);
                taskService.addTask(task);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Task stringToTask(String[] taskStringParts) {
        int id = Integer.parseInt(taskStringParts[0]);
        String taskTitle = taskStringParts[1];
        TaskPriority taskPriority = TaskPriority.valueOf(taskStringParts[2].toUpperCase());
        return new Task(id, taskTitle, taskPriority); // В этом методе возможно исключение если в
        // taskStringParts будут не верные параметры (к примеру не так расставили поля в excel)

        //Нужно будет в этом методе написать Exception.
    }

}
