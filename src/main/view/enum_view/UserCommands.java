package src.main.view.enum_view;

public enum UserCommands {
    ENTER_TASK("Введите таск"),
    ENTER_ID("Введите id"),
    REMOVE_NUMBER("Введите id таска которого хотите удалить"),
    ENTER_NAME_OF_FILE("Введите название CSV файл с которого хотите считать данные"),
    ENTER_PRIORITY("Введите приоретет таска в указанном формате (Low/Medium/High)");
    public String commandName;

    UserCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
