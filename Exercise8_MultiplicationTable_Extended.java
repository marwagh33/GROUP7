import java.util.Scanner;

public class Exercise8_MultiplicationTable_Extended {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Multiplication Table Generator ===");

        // Option menu for user to choose
        System.out.println("\nChoose an option:");
        System.out.println("1. Single number table");
        System.out.println("2. Table with start and end range");
        System.out.println("3. Full multiplication table (1–10)");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
//choice for user after he choose
        switch (choice) {
//dsplay the number that user write and multiply by 1-12
 
            case 1:
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();

                for (int i = 1; i <= 12; i++) {
                    System.out.println(number + " x " + i + " = " + (number * i));
                }
                break;
// display the multiplication of start range and end range and create full multiplication table (1-10 x 1-10) using nested loops

            case 2:
                System.out.print("Enter your number: ");
                int num = scanner.nextInt();

                System.out.print("Enter start range: ");
                int start = scanner.nextInt();

                System.out.print("Enter end range: ");
                int end = scanner.nextInt();

                for (int i = start; i <= end; i++) {
                    System.out.println(num + " x " + i + " = " + (num * i));
                }
                break;
// show full multiplication of table for multiple numbers 

            case 3:
                System.out.println("\nFull Multiplication Table (1–10)\n");

                for (int i = 1; i <= 10; i++) {
                     for (int m = 1; m <= 10; m++) {
                        System.out.print(i + "x" + m + "=" + (i * m) + "  ");
                        }
                  System.out.println();
                }

                break;
// the user write any numbers except 1 2 and 3
            default:
                System.out.println("Invalid choice ");
        }

        scanner.close();
    }
}


/*
 * SAMPLE OUTPUT:
 * =============
 *
 * === Multiplication Table Generator ===
 *
 * Enter a number: 7
 *
 * Multiplication Table for 7:
 * ================================
 * 7 x  1 =   7
 * 7 x  2 =  14
 * 7 x  3 =  21
 * 7 x  4 =  28
 * 7 x  5 =  35
 * 7 x  6 =  42
 * 7 x  7 =  49
 * 7 x  8 =  56
 * 7 x  9 =  63
 * 7 x 10 =  70
 * 7 x 11 =  77
 * 7 x 12 =  84
 * ================================
 *
 * EXTENSION CHALLENGE:
 * - Ask user for start and end range
 * - Create a full multiplication table (1-10 x 1-10) using nested loops
 * - Add an option to display tables for multiple numbers
 */
