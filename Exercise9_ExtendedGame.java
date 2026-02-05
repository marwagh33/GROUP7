import java.util.Scanner;
import java.util.Random;

/**
 * Exercise 9: Number Guessing Game
 * PT821 - Object-Oriented Programming
 *
 * TASK:
 * Create a game where:
 * 1. Computer generates a random number between 1 and 100
 * 2. User tries to guess the number
 * 3. Program gives hints (too high, too low)
 * 4. Uses a while loop until user guesses correctly
 * 5. Counts the number of attempts
 *
 * CONCEPTS PRACTICED:
 * - while loop
 * - if-else statements
 * - Random number generation
 * - Counter variable
 */
import java.util.Scanner;
import java.util.Random;

public class Exercise9_ExtendedGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char playAgain;
          //Maximum number and attempts
        do {
            int maxNumber = 100;
            int maxAttempts = 10;

            // Difficulty levels
            System.out.println("Choose Difficulty Level:");
            System.out.println("1. Easy (1 - 50)");
            System.out.println("2. Medium (1 - 100)");
            System.out.println("3. Hard (1 - 1000)");
            System.out.print("Enter your choice: ");

            //choosing the levels

            int choice = scanner.nextInt();

            if (choice == 1) {
                maxNumber = 50;
            } else if (choice == 2) {
                maxNumber = 100;
            } else if (choice == 3) {
                maxNumber = 1000;
            }
            

            int secretNumber = random.nextInt(maxNumber) + 1;
            int guess = 0;
            int attempts = 0;
            
            System.out.println("=== Number Guessing Game ===");
            System.out.println("\nGuess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.\n");

            // Guessing the number with attempt limit
            while (guess != secretNumber && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low!\n");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!\n");
                }
            }

            // Result for guess
            if (guess == secretNumber) {
                System.out.println("🎉 You guessed it in " + attempts + " attempts!");
            } else {
                System.out.println("❌ Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }
            //Rating Attempts
            
            if (attempts <= 5) { 
            System.out.println("Rating: Excellent! You're a mind reader!"); 
            } else if (attempts <= 10) { System.out.println("Rating: Good job!"); 
            }else { System.out.println("Rating: You got it eventually!");
            }

            // Allow users to Play again
            System.out.print("\nPlay again?: ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain != 's');

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
    

}



/*
 * SAMPLE OUTPUT:
 * =============
 *
 * === Number Guessing Game ===
 *
 * I'm thinking of a number between 1 and 100.
 * Try to guess it!
 *
 * Enter your guess: 50
 * Too low! Try again.
 *
 * Enter your guess: 75
 * Too high! Try again.
 *
 * Enter your guess: 62
 * Too low! Try again.
 *
 * Enter your guess: 68
 *
 * 🎉 Congratulations!
 * You guessed it in 4 attempts!
 * Rating: Excellent! You're a mind reader!
 *
 * EXTENSION CHALLENGE:
 * - Add a maximum number of attempts (e.g., 10)
 * - Add difficulty levels (1-50, 1-100, 1-1000)
 * - Allow user to play again without restarting
 */
