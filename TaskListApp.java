import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(sc);

            switch (choice) {
                case 1:
                    taskList.addTask(getTaskName(sc));
                    break;
                case 2:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumber = getUserInput(sc, "Enter the task number to remove: ");
                        if (taskList.isValidTaskNumber(taskNumber)) {
                            taskList.removeTask(taskNumber);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to remove.");
                    }
                    break;
                case 3:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                    } else {
                        System.out.println("No tasks to list.");
                    }
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Quit");
        System.out.print("Select an option: ");
    }

    private static int getUserChoice(Scanner sc) {
        return sc.nextInt();
    }

    private static String getTaskName(Scanner sc) {
        System.out.print("Enter task name: ");
        return sc.next();
    }

    private static int getUserInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }
}

class TaskList {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(name);
        System.out.println("Task added.");
    }

    public void removeTask(int taskNumber) {
        tasks.remove(taskNumber - 1);
        System.out.println("Task removed.");
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}

