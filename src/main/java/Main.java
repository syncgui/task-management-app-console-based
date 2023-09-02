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
            option = askForIntegerChoice();

            switch (option) {
                case 1 -> { // add new task
                    System.out.print("""
                            Choose the task type:
                            1. Work task
                            2. Home task
                            """);
                    int innerOption = askForIntegerChoice();

                    if (innerOption == 1) { // if user choose work task
                        int id = askForId();
                        while (taskManager.idExistsOrBelowOne(id)) {
                            id = askForId();
                        }

                        System.out.print("Enter the task title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter a description for this task: ");
                        String description = scanner.nextLine();

                        System.out.println("Choose the task type: ");
                        EnumWorkType.printValues();
                        int workTypeOption = askForIntegerChoice();
                        EnumWorkType workTypeOptionSelected = EnumWorkType.values()[workTypeOption];

                        System.out.println("Choose the task priority: ");
                        EnumPriority.printValues();
                        int priorityOption = askForIntegerChoice();
                        EnumPriority workPriorityOptionSelected = EnumPriority.values()[priorityOption];

                        System.out.println("Choose the task reporter: ");
                        EnumWorkReporter.printValues();
                        int reporterOption = askForIntegerChoice();
                        EnumWorkReporter workReporterOptionSelected = EnumWorkReporter.values()[reporterOption];

                        ITask workTask = new WorkTask(id, title, description,
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
                        int homeTypeOption = askForIntegerChoice();
                        EnumHomeType homeTypeOptionSelected = EnumHomeType.values()[homeTypeOption];

                        System.out.println("Choose the room for this task: ");
                        EnumHomeRoom.printValues();
                        int homeRoomOption = askForIntegerChoice();
                        EnumHomeRoom homeRoomOptionSelected = EnumHomeRoom.values()[homeRoomOption];

                        System.out.println("Choose the task priority: ");
                        EnumPriority.printValues();
                        int priorityOption = askForIntegerChoice();
                        EnumPriority homePriorityOptionSelected = EnumPriority.values()[priorityOption];

                        ITask homeTask = new HomeTask(id, title, description,
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
                case 4 -> taskManager.getAllTasks(); // list all tasks
            }
        }
        System.out.println("Exiting program!");
        scanner.close();
    }

    private static int askForId() {
        System.out.print("Enter the task identifier: ");
        return askForIntegerChoice();
    }

    private static int askForIntegerChoice() {
        try {
            String number = scanner.nextLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.print("Invalid input. Please enter a number: ");
            return askForIntegerChoice();
        }
    }
}
