import java.util.*;
/**
 * Use Case 2: User Guess Submission
 * This is responsible for handling user input and validating guesses against the target number.
 * It Does not handle Input or Output
 * 
 * @author Developer
 * @version 2.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game!");
        GameConfig config = new GameConfig();
        config.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while(attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            System.out.println(result);

            if("Correct!".equals(result)){
                break;
            }
        }
    }
}
