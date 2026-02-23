/**
 * Use Case 5: Game Result Storage
 * 
 * This class coordinates the complete game flow
 * and persists the final result after completeion.
 * 
 * Responsibilities:
 *  - Initialize game configuration
 *  - Accept and validate user guesses
 *  - Generate hints when applicable
 *  - Store game resut at the end.
 * 
 * @author Developer
 * @version 5.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n-------------------------------");
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("-------------------------------\n");

        /**
         * Player name is captured once
         * and stored along with game results.
         */
        System.out.println("Enter Player Name: ");
        String player = sc.nextLine();

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;

        /**
         * Tracks whether the player
         * successfully guessed the number.
         */
        boolean win = false;

        /**
         * Game loop runs until the player
         * exhausts all attempts or guesses correctly.
         */
        while(attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");

            /**
             * User input is validated before
             * being used in the game logic.
             */
            int guess = ValidationService.validateInput(sc.nextLine());
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());

            if(!"Correct!".equals(result) && hintsUsed < config.getMaxHints()) {
                hintsUsed++;
                System.out.println(HintService.generateHint(config.getTargetNumber(), hintsUsed));
            }

            System.out.println(result);

            /**
             * Stop the loop immediately
             * if the correct number is guessed
             */

            if ("Correct!".equals(result)) {
                win = true;
                break;
            }
        }
    
        StorageService.saveResult(player, attempts, win);

        sc.close();
    
    }
}