package src.main.view.enum_view;

public enum MenuCommands {
    ADDTASK("Нажмите 1 что бы добавить таск"),
    REMOVETASK("Нажмите 2 что бы удалить таск (Введите его индекс)"),
    SHOWTASKS("Нажмите 3 что бы увидеть все таски"),
    EXIT("Нажмите 4 что бы выйти из программы");
    public String commandName;

    MenuCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
