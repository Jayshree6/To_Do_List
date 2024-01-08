import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    displayTasks();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Todo List Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. Edit Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Display Tasks");
        System.out.println("0. Exit");
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        scanner.nextLine(); // Consume the newline character
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void editTask() {
        displayTasks();
        System.out.print("Enter the index of the task to edit: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < tasks.size()) {
            System.out.print("Enter the new task: ");
            scanner.nextLine(); // Consume the newline character
            String newTask = scanner.nextLine();
            tasks.set(index, newTask);
            System.out.println("Task edited successfully!");
        } else {
            System.out.println("Invalid index. No task edited.");
        }
    }

    private static void deleteTask() {
        displayTasks();
        System.out.print("Enter the index of the task to delete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid index. No task deleted.");
        }
    }

    private static void displayTasks() {
        System.out.println("\n===== Tasks =====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
