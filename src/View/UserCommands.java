package src.View;

public enum UserCommands {
    addTask("Нажмите 1 что бы добавить таск"),
    removeTask("Нажмите 2 что бы удалить таск (Введите его индекс)"),
    showTasks("Нажмите 3 что бы увидеть все таски"),
    exit("Нажмите 4 что бы выйти из программы");

    public String commandName;

    UserCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
