package src.View;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskView {
    private Scanner input;

    public TaskView() {
        input = new Scanner(System.in);
    }

    public void showMenu(){
        for(UserCommands userCommands : UserCommands.values()){
            System.out.println(userCommands.commandName);
        }
    }

    public int getInt(){
        return input.nextInt();
    }

    public String getString(){
        return input.nextLine();
    }
    public void showString(String string){
        System.out.println(string);
    }

    public void clearBuffer(){
        input.nextLine();
    }
}
