import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option = 0;

        TaskManager taskManager = new TaskManager();

        while (option != 5) {
            System.out.print("""
                    Welcome to the Task Manager!
                                    
                    1. Add task
                    2. Complete task
                    3. Delete task
                    4. List all tasks
                    5. Close the program
                                    
                    Choose a option by typing the corresponding number:
                    """);
            option = scanner.nextInt();

            switch (option) {
                case 1 -> { // add new task
                    System.out.print("""
                            Choose the task type:
                            1. Work task
                            2. Home task
                            """);
                    int innerOption = scanner.nextInt();

                    if (innerOption == 1) { // if user choose work task
                        int id = askForId();
                        while (taskManager.idExistsOrBelowOne(id)) {
                            id = askForId();
                        }
                        scanner.nextLine();

                        System.out.print("Enter the task title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter a description for this task: ");
                        String description = scanner.nextLine();

                        System.out.println("Choose the task type: ");
                        EnumWorkType.printValues();
                        int workTypeOption = scanner.nextInt();
                        EnumWorkType workTypeOptionSelected = EnumWorkType.values()[workTypeOption];

                        System.out.println("Choose the task priority: ");
                        EnumPriority.printValues();
                        int priorityOption = scanner.nextInt();
                        EnumPriority workPriorityOptionSelected = EnumPriority.values()[priorityOption];

                        System.out.println("Choose the task reporter: ");
                        EnumWorkReporter.printValues();
                        int reporterOption = scanner.nextInt();
                        EnumWorkReporter workReporterOptionSelected = EnumWorkReporter.values()[reporterOption];

                        WorkTask workTask = new WorkTask(id, title, description,
                                workTypeOptionSelected, workPriorityOptionSelected, workReporterOptionSelected);

                        taskManager.addTask(workTask);

                    } else if (innerOption == 2) { // if user choose home task
                        int id = askForId();
                        while (taskManager.idExistsOrBelowOne(id)) {
                            id = askForId();
                        }

                        System.out.print("Enter the task title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter a description for this task: ");
                        String description = scanner.nextLine();

                        System.out.println("Choose the task type: ");
                        EnumHomeType.printValues();
                        int homeTypeOption = scanner.nextInt();
                        EnumHomeType homeTypeOptionSelected = EnumHomeType.values()[homeTypeOption];

                        System.out.println("Choose the room for this task: ");
                        EnumHomeRoom.printValues();
                        int homeRoomOption = scanner.nextInt();
                        EnumHomeRoom homeRoomOptionSelected = EnumHomeRoom.values()[homeRoomOption];

                        System.out.println("Choose the task priority: ");
                        EnumPriority.printValues();
                        int priorityOption = scanner.nextInt();
                        EnumPriority homePriorityOptionSelected = EnumPriority.values()[priorityOption];

                        HomeTask homeTask = new HomeTask(id, title, description,
                                homeTypeOptionSelected, homeRoomOptionSelected, homePriorityOptionSelected);

                        taskManager.addTask(homeTask);

                    } else { // if user enter e invalid option
                        System.out.println("Invalid option!");
                    }
                }
                case 2 -> { // complete task
                    int id = askForId();
                    while (!taskManager.markAsComplete(id)) {
                        id = askForId();
                    }
                }
                case 3 -> { // delete task
                    int id = askForId();
                    while (!taskManager.deleteTask(id)) {
                        id = askForId();
                    }
                }
                case 4 -> { // list all tasks
                    taskManager.getAllTasks();
                }
            }
        }
        System.out.println("Exiting program!");
        scanner.close();
    }

    private static int askForId() {
        System.out.print("Enter the task identifier: ");
        return scanner.nextInt();
    }
}
