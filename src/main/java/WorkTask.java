public class WorkTask implements ITask{

    private final int id;
    private final String title;
    private final String description;
    private final EnumWorkType type;
    private final EnumPriority priority;
    private final EnumWorkReporter reporter;
    private boolean Completed = false;

    //CONSTRUCTOR
    public WorkTask(int id, String title, String description, EnumWorkType type, EnumPriority priority, EnumWorkReporter reporter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.priority = priority;
        this.reporter = reporter;
    }

    //TO STRING
    @Override
    public String toString() {
        return "WorkTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                ", reporter=" + reporter +
                ", Completed=" + Completed +
                '}';
    }

    // MARK TASK AS COMPLETE
    @Override
    public void markAsComplete() {
        Completed = true;
    }

    // GET ID VALUE
    @Override
    public int getId() {
        return id;
    }

    //CHECK IF TASK IS COMPLETED
    @Override
    public boolean isCompleted() {
        return Completed;
    }

}
