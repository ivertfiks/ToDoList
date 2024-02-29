package src.View;

import java.util.Scanner;

public class TaskView {
    private Scanner input;

    public TaskView() {
        input = new Scanner(System.in);
    }

    public void showMenu(){
        for(UserCommands userCommands : UserCommands.values()){
            System.out.println(userCommands.getCommandName());
        }
    }

    public String putString(){
        return input.nextLine();
    }
}
