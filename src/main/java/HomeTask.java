public class HomeTask implements ITask{

    private final int id;
    private final String title;
    private final String description;
    private final EnumHomeType homeType;
    private final EnumHomeRoom room;
    private final EnumPriority priority;
    private boolean isCompleted = false;

    //CONSTRUCTOR
    public HomeTask(int id, String title, String description, EnumHomeType homeType, EnumHomeRoom room, EnumPriority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.homeType = homeType;
        this.room = room;
        this.priority = priority;
    }

    //TO STRING
    @Override
    public String toString() {
        return "HomeTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", homeType=" + homeType +
                ", room=" + room +
                ", priority=" + priority +
                ", isCompleted=" + isCompleted +
                '}';
    }

    //MARK TASK AS COMPLETE
    @Override
    public void markAsComplete() {
        isCompleted = true;
    }

    //GET ID VALUE
    @Override
    public int getId() {
        return id;
    }

    //CHECK IF TASK IS COMPLETED
    @Override
    public boolean isCompleted() {
        return isCompleted;
    }
}
