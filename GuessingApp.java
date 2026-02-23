/**
 * Use Case 4: Error Handling and Validation
 * 
 * This class coordinated the game execution while ensuring
 * all user inputs are safely validated before processing.
 * 
 * Responsibilities:
 *  - Initialize game configuration and rules.
 *  - Accept User Input
 *  - Validate the input using GuessValidator.
 *  - Handle Game flow without crashing on invalid input
 * 
 * @author Developer
 * @version 4.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing Game!");
        GameConfig config = new GameConfig();
        HintService hs = new HintService();
        config.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;

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
                break;
            }
        }
    }
}