/**
 * Use Case 6: Game Restart & Exit
 * 
 * This class coordinates the complete game lifecycle
 * allowing the player to replay or exit gracefully.
 * 
 * Responsibilities:
 *  - Initialize game configuration
 *  - Accept and validate user guesses
 *  - Generate hints when applicable
 *  - Store game resut at the end.
 * 
 * @author Developer
 * @version 6.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException {

        Scanner sc = new Scanner(System.in);
		boolean restart;

        System.out.println("\n-------------------------------");
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("-------------------------------\n");

        /**
         * Outer loop controls whether
         * a new game session should start
         */
		do {
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
			 * Inner loop handles the guessing
			 * logic for a single game session.
			 */
			while(attempts < config.getMaxAttempts()) {
				System.out.print("Enter your guess: ");

				/**
				 * Final game result is persisted
				 * after the current session ends.
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
			
			/*
			* Player decides whether to
			* restart the game or exit.
			*/
			restart = GameController.restartGame(sc);

        } while (restart);
    
    }
}