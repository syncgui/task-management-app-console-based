import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    List<ITask> taskList = new ArrayList<>();

    public void addTask(ITask task) {
        if (task.getId() >= 0) {
            taskList.add(task);
            System.out.println("Task added");

        } else {
            System.out.println("Error while adding the task: (Task already exists or must be positive)");
        }
    }

    public boolean deleteTask(int id) {
        if (taskList.removeIf(a -> a.getId() == id)) {
            System.out.println("Task removed");
            return true;
        } else {
            System.out.println("Task not found");
            return false;
        }
    }

    public boolean markAsComplete(int id) {
        boolean result = taskList.stream().anyMatch(a -> {
            if (a.getId() == id && !a.isCompleted()) {
                a.markAsComplete();
                return true;
            }
            return false;
        });

        if (result) {
            System.out.println("Task completed!");
            return true;
        } else {
            System.out.println("Task already completed or not found!");
            return false;
        }
    }

    public boolean idExistsOrBelowOne(int id) {
        boolean exists = taskList.stream().anyMatch(a -> a.getId() == id);
        if (exists) {
            System.out.println("ID already exists!");
        return exists;
        } else if (id < 1) {
            System.out.println("ID must be positive!");
            return true;
        }
        return false;
    }

    public void getAllTasks() {
        taskList.forEach(System.out::println);
    }
}
