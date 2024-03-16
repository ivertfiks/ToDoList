package src.main.service;
import src.main.model.Task;
import src.main.model.enum_model.TaskPriority;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    List<List<String>> listsOfTasks;
    TaskService taskService = new TaskService();
    public FileOperations() {
        listsOfTasks = new ArrayList<>();
    }
    public TaskService stringToTasks(){
        taskService = new TaskService();
        int id;
        String taskTitle;
        TaskPriority taskPriority;
        for(List<String> task : listsOfTasks){
            try {
                id = Integer.parseInt(task.get(0));
                taskTitle = task.get(1);
                taskPriority = TaskPriority.valueOf(task.get(2).toUpperCase());
                taskService.addTask(new Task(id, taskTitle, taskPriority));
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e);
            }
        }
        return taskService;
    }
    public void writeInFile(TaskService taskService) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id;").append("name;").append("taskPriority").append("\n");
        File csvFile = new File("task.csv");
        try(FileWriter fileWriter = new FileWriter(csvFile)){
        for(Task task : taskService.getTaskList()){
            stringBuilder.append(task.getId());
            stringBuilder.append(";");
            stringBuilder.append(task.getTask());
            stringBuilder.append(";");
            stringBuilder.append(task.getTaskPriority());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void readFromFile(String path) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] strings = line.split(",");
                String[] splits = new String[0];
                for(String s : strings){
                    splits = s.split(";");
                }   
                listsOfTasks.add(Arrays.asList(splits));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
