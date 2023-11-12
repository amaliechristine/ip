public class Task {
    
    private String description;
    private int priority;
    private int workload;

    public Task(String description, int priority, int workload) {
        this.description = description;
        this.priority = priority;
        this.workload = workload;
    }

    public String toString() {
        String translatePriority = "";
        if (priority==1) {
            translatePriority = "very important";
        }
        if (priority==2) {
            translatePriority = "important";
        }
        if (priority==3) {
            translatePriority = "unimportant";
        }
        if (priority==4) {
            translatePriority = "after learn Portuguese";
        }
        return description + " takes " + workload + " minutes and has priority " + translatePriority;
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }
}