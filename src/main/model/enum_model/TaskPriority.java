package src.main.model.enum_model;

public enum TaskPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");


    TaskPriority(String priority) {
        this.priority = priority;
    }

    String priority;

    public String getPriority() {
        return priority;
    }
}
