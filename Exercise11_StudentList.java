import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise 11: Student List Manager
 * PT821 - Object-Oriented Programming
 *
 * TASK:
 * Create a program that manages a list of students using ArrayList:
 * 1. Add a student
 * 2. Remove a student
 * 3. View all students
 * 4. Search for a student
 * 5. Count total students
 * 6. Exit
 *
 * CONCEPTS PRACTICED:
 * - ArrayList operations (add, remove, contains, size)
 * - do-while loop for menu
 * - switch-case for menu selection
 * - Methods/functions
 */
import java.util.Scanner;
public class Exercise11_StudentList {
    public Exercise11_StudentList() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Initialize sum, max, and min
        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        // Process numbers to find sum, max, and min
        for (int num : numbers) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // Calculate average
        double average = (double) sum / numbers.length;

        // Display results
        System.out.print("All numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);

        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        int choice;

        System.out.println("=== Student List Manager ===\n");

        do {
            // Display menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. View all students");
            System.out.println("4. Search for a student");
            System.out.println("5. Count total students");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student name: ");
                    String nameToAdd = scanner.nextLine();
                    students.add(nameToAdd);
                    System.out.println("✓ " + nameToAdd + " added successfully!");
                    break;

                case 2:
                    // Remove student
                    if (students.isEmpty()) {
                        System.out.println("No students to remove!");
                    } else {
                        System.out.print("Enter student name to remove: ");
                        String nameToRemove = scanner.nextLine();
                        if (students.remove(nameToRemove)) {
                            System.out.println("✓ " + nameToRemove + " removed successfully!");
                        } else {
                            System.out.println("✗ Student not found!");
                        }
                    }
                    break;

                case 3:
                    // View all students
                    if (students.isEmpty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                case 4:
                    // Search for student
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    if (students.contains(searchName)) {
                        int index = students.indexOf(searchName);
                        System.out.println("✓ Found! " + searchName + " is at position " + (index + 1));
                    } else {
                        System.out.println("✗ Student not found!");
                    }
                    break;

                case 5:
                    // Count students
                    System.out.println("Total students: " + students.size());
                    break;

                case 6:
                    // Exit
                    System.out.println("\nThank you for using Student List Manager!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}

    
/*
 * SAMPLE OUTPUT:
 * =============
 *
 * === Student List Manager ===
 *
 * --- Menu ---
 * 1. Add a student
 * 2. Remove a student
 * 3. View all students
 * 4. Search for a student
 * 5. Count total students
 * 6. Exit
 *
 * Enter your choice (1-6): 1
 * Enter student name: Ali Mohamed
 * ✓ Ali Mohamed added successfully!
 *
 * --- Menu ---
 * ...
 * Enter your choice (1-6): 3
 *
 * --- Student List ---
 * 1. Ali Mohamed
 * 2. Fatma Hassan
 *
 * EXTENSION CHALLENGE:
 * - Add student ID along with name
 * - Save/load students from a file
 * - Sort students alphabetically
 * - Edit student name
 */
